package interviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(String message) {
        System.out.println("ApplicationContextPublisher: Publishing event.");
        CustomEvent customEvent = new CustomEvent(message);
        applicationContext.publishEvent(customEvent);
    }
}
