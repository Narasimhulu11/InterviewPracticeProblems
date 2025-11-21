package interviews;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "example.feature.enabled", havingValue = "true")
public class ConditionalOnExample {

    public ConditionalOnExample() {
        System.out.println("ConditionalOnExample: Bean created because condition is met.");
    }
}
