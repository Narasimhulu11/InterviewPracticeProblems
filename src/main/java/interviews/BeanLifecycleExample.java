package interviews;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycleExample implements InitializingBean, DisposableBean {

    public BeanLifecycleExample() {
        System.out.println("BeanLifecycleExample: Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanLifecycleExample: @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifecycleExample: afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanLifecycleExample: @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanLifecycleExample: destroy");
    }
}
