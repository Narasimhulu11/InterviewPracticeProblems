package interviews;

import org.example.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherAwareExample implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(String message) {
        System.out.println("EventPublisherAwareExample: Publishing event.");
        CustomEvent customEvent = new CustomEvent(message);
        applicationEventPublisher.publishEvent(customEvent);
    }
}
