package api.bpartners.annotator.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"annotation_batch_subset\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationBatchSubset {
  @Id private String id;
  private String jobId;

  @OneToMany(mappedBy = "subsetId", cascade = CascadeType.ALL)
  private List<AnnotationBatch> batches;
}