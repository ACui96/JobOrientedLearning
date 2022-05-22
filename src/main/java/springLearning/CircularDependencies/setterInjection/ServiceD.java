package springLearning.CircularDependencies.setterInjection;

import org.springframework.stereotype.Component;

/**
 * @author Acui
 * @date 2022年05月22日 21:18
 */
@Component
public class ServiceD {
    private ServiceC serviceC;

    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
        System.out.println("D设置C");
    }
}
