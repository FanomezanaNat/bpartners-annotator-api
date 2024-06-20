package api.bpartners.annotator.service.JobExport;

import static java.util.UUID.randomUUID;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import api.bpartners.annotator.endpoint.event.EventProducer;
import api.bpartners.annotator.endpoint.event.model.JobExportInitiated;
import api.bpartners.annotator.endpoint.rest.controller.mapper.InternetAddressMapper;
import api.bpartners.annotator.endpoint.rest.model.ExportFormat;
import api.bpartners.annotator.model.exception.BadRequestException;
import api.bpartners.annotator.repository.model.AnnotationBatchSubset;
import api.bpartners.annotator.repository.model.Job;
import api.bpartners.annotator.service.AnnotationBatchService;
import api.bpartners.annotator.service.AnnotationBatchSubsetService;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ExportService {
  private static final int PARTITION_SIZE = 200;
  private static final int MAX_HANDLED_BATCH_SIZE = 200;
  private final EventProducer eventProducer;
  private final VggExportService vggExportService;
  private final CocoExportService cocoExportService;
  private final AnnotationBatchService annotationBatchService;
  private final AnnotationBatchSubsetService annotationBatchSubsetService;

  @SneakyThrows
  public void initiateJobExport(String jobId, ExportFormat exportFormat, String emailCC) {
    var batches = annotationBatchService.findLatestPerTaskByJobId(jobId);
    var subSets =
        batches.size() > MAX_HANDLED_BATCH_SIZE
            ? Lists.partition(batches, PARTITION_SIZE)
            : List.of(batches);
    var toSave =
        subSets.stream()
            .map(subset -> new AnnotationBatchSubset(randomUUID().toString(), jobId, subset))
            .toList();
    var saved = annotationBatchSubsetService.saveAll(toSave);

    saved.forEach(
        subset -> {
          eventProducer.accept(
              List.of(
                  new JobExportInitiated(
                      jobId, subset.getId(), exportFormat, InternetAddressMapper.from(emailCC))));
        });
  }

  @Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
  public Object exportJob(Job job, ExportFormat format, String subsetId) {
    var subset = annotationBatchSubsetService.getSubSetById(subsetId);
    return switch (format) {
      case VGG -> vggExportService.export(job, subset.getBatches());
      case COCO -> cocoExportService.export(job, subset.getBatches());
      case null -> throw new BadRequestException("unknown export format " + format);
    };
  }
}
