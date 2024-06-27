package api.bpartners.annotator.service.event;

import static java.util.UUID.randomUUID;

import api.bpartners.annotator.datastructure.ListGrouper;
import api.bpartners.annotator.endpoint.event.EventProducer;
import api.bpartners.annotator.endpoint.event.model.ExportTaskCreated;
import api.bpartners.annotator.endpoint.event.model.JobExportInitiated;
import api.bpartners.annotator.endpoint.rest.model.ExportFormat;
import api.bpartners.annotator.repository.model.AnnotationBatch;
import api.bpartners.annotator.repository.model.ExportTask;
import api.bpartners.annotator.service.AnnotationBatchService;
import api.bpartners.annotator.service.ExportTaskService;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class JobExportInitiatedService implements Consumer<JobExportInitiated> {
  // TODO: put as env vars
  private static final int BATCH_PARTITION_SIZE = 1000;
  private static final int MAX_HANDLED_BATCH_SIZE = 1200;
  private final AnnotationBatchService annotationBatchService;
  private final ExportTaskService exportTaskService;
  private final EventProducer<ExportTaskCreated> eventProducer;
  private final ListGrouper<AnnotationBatch> listGrouper;

  @Override
  @Transactional
  public void accept(JobExportInitiated jobExportInitiated) {
    String jobId = jobExportInitiated.getJobId();
    ExportFormat format = jobExportInitiated.getExportFormat();
    InternetAddress emailCC = jobExportInitiated.getEmailCC();
    var batches = annotationBatchService.findLatestPerTaskByJobId(jobId);
    log.info("Found {} batches", batches.size());
    List<List<AnnotationBatch>> subBatches = split(batches);
    var savedTasks = createTasks(jobId, subBatches);
    log.info("will create {} events", savedTasks.size());
    savedTasks.forEach(
        task ->
            eventProducer.accept(
                List.of(new ExportTaskCreated(jobId, task.getId(), format, emailCC))));
  }

  private List<List<AnnotationBatch>> split(List<AnnotationBatch> batches) {
    log.info("Splitting {} batches", batches.size());
    return listGrouper.apply(batches, BATCH_PARTITION_SIZE);
  }

  private List<ExportTask> createTasks(String jobId, List<List<AnnotationBatch>> subBatches) {
    var tasks = subBatches.stream().map(subBatch -> createExportTask(jobId, subBatch)).toList();
    return exportTaskService.saveAll(tasks);
  }

  private ExportTask createExportTask(String jobId, List<AnnotationBatch> subBatch) {
    String taskId = randomUUID().toString();
    var toSave =
        subBatch.stream().peek(annotationBatch -> annotationBatch.setExportTaskId(taskId)).toList();
    return ExportTask.builder()
        .id(taskId)
        .jobId(jobId)
        .annotationBatches(toSave)
        // no need to set status as default getStatus will return pending unknown on empty
        .statusHistory(List.of())
        .build();
  }
}
