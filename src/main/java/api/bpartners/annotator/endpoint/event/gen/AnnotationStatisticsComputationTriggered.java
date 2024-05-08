package api.bpartners.annotator.endpoint.event.gen;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.mail.internet.InternetAddress;
import java.io.Serializable;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Generated("EventBridge")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode
@ToString
public class AnnotationStatisticsComputationTriggered implements Serializable {
  @JsonProperty("job_id")
  private String jobId;

  @JsonProperty("email_cc")
  private InternetAddress emailCC;
}
