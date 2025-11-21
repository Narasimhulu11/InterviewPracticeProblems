package interviews;

import org.example.ApplicationContextPublisher;
import org.example.EventPublisher;
import org.example.EventPublisherAwareExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringPracticeApplication.class, args);

        // Publish a custom event
        EventPublisher publisher = context.getBean(EventPublisher.class);
        publisher.publishEvent("Hello, Spring Events! in EventPublisher");

        EventPublisherAwareExample eventPublisherAwareExample = context.getBean(EventPublisherAwareExample.class);
        eventPublisherAwareExample.publishEvent("Hello, Spring Events! EventPublisherAwareExample");

        ApplicationContextPublisher applicationContextPublisher = context.getBean(ApplicationContextPublisher.class);
        publisher.publishEvent("Hello, Spring Events! ApplicationContextPublisher");

        // Close the context to trigger bean destruction
        context.close();
    }
}
