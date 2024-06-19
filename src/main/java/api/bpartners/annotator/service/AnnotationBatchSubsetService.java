package api.bpartners.annotator.service;

import api.bpartners.annotator.model.exception.NotFoundException;
import api.bpartners.annotator.repository.jpa.AnnotationBatchSubsetRepository;
import api.bpartners.annotator.repository.model.AnnotationBatchSubset;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnnotationBatchSubsetService {
  private final AnnotationBatchSubsetRepository repository;

  public AnnotationBatchSubset getSubSetById(String id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Subset.id=" + id + " is not found."));
  }

  public List<AnnotationBatchSubset> saveAll(List<AnnotationBatchSubset> subsets) {
    var toSave =
        subsets.stream()
            .peek(
                subset -> {
                  var batches =
                      subset.getBatches().stream()
                          .peek(batch -> batch.setSubsetId(subset.getId()))
                          .toList();
                  subset.setBatches(batches);
                })
            .toList();
    return repository.saveAll(toSave);
  }

  private AnnotationBatchSubset save(AnnotationBatchSubset toSave) {

    return repository.save(toSave);
  }
}
