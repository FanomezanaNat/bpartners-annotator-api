package api.bpartners.annotator.endpoint.event.model;

import static api.bpartners.annotator.endpoint.event.EventStack.EVENT_STACK_1;
import static java.lang.Math.random;

import api.bpartners.annotator.PojaGenerated;
import api.bpartners.annotator.endpoint.event.EventStack;
import java.io.Serializable;
import java.time.Duration;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
@SuppressWarnings("all")
public abstract class PojaEvent implements Serializable {

  @Getter @Setter protected int attemptNb;

  public abstract Duration maxConsumerDuration();

  private Duration randomConsumerBackoffBetweenRetries() {
    return Duration.ofSeconds((int) (random() * maxConsumerBackoffBetweenRetries().toSeconds()));
  }

  public abstract Duration maxConsumerBackoffBetweenRetries();

  public final Duration randomVisibilityTimeout() {
    var eventHandlerInitMaxDuration = Duration.ofSeconds(90); // note(init-visibility)
    return Duration.ofSeconds(
        eventHandlerInitMaxDuration.toSeconds()
            + maxConsumerDuration().toSeconds()
            + randomConsumerBackoffBetweenRetries().toSeconds());
  }

  public EventStack getEventStack() {
    return EVENT_STACK_1;
  }

  public String getEventSource() {
    if (getEventStack().equals(EVENT_STACK_1)) return "api.bpartners.annotator.event1";
    return "api.bpartners.annotator.event2";
  }
}
