package api.bpartners.annotator.endpoint.event.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class AnnotationStatisticsComputationTriggeredTest {

  @Test
  void get_attributes_ok() {
    var event = new AnnotationStatisticsComputationTriggered();

    assertEquals(Duration.ofMinutes(2), event.maxConsumerDuration());
    assertEquals(Duration.ofMinutes(1), event.maxConsumerBackoffBetweenRetries());
  }
}
