package springLearning.CircularDependencies.constructorInjection;

import org.springframework.stereotype.Component;

/**
 * @author Acui
 * @date 2022年05月22日 21:07
 */
@Component
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
