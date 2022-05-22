package springLearning.CircularDependencies.circularDepWithContainer;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springLearning.CircularDependencies.setterInjection.ServiceC;
import springLearning.CircularDependencies.setterInjection.ServiceD;

/**
 * @author Acui
 * @date 2022年05月23日 8:41
 */
public class Main {
    public static void main(String[] args) {

         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceC c = context.getBean("c", ServiceC.class);
        ServiceD d = context.getBean("d", ServiceD.class);
    }
}
 // f8 步过 步入 强制步入 跳出