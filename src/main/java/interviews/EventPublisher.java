package interviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(String message) {
        System.out.println("EventPublisher: Publishing event.");
        CustomEvent customEvent = new CustomEvent(message);
        applicationEventPublisher.publishEvent(customEvent);
    }
}
