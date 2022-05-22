package springLearning.CircularDependencies.setterInjection;

import org.springframework.stereotype.Component;

/**
 * @author Acui
 * @date 2022年05月22日 21:16
 */
@Component
public class ServiceC {
    private ServiceD serviceD;

    public void setServiceD(ServiceD serviceD) {
        this.serviceD = serviceD;
        System.out.println("C里设置了D");
    }
}
