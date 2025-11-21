package interviews;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycleExample2 {

    public BeanLifecycleExample2() {
        System.out.println("BeanLifecycleExample2: Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("BeanLifecycleExample2: @PostConstruct - init method");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("BeanLifecycleExample2: @PreDestroy - cleanup method");
    }
}
