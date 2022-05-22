package springLearning.CircularDependencies.constructorInjection;

import org.springframework.stereotype.Component;

/**
 * @author Acui
 * @date 2022年05月22日 21:08
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
