package springLearning.CircularDependencies.setterInjection;

/**
 * @author Acui
 * @date 2022年05月22日 21:19
 */
public class Main {
    public static void main(String[] args) {
        ServiceC c = new ServiceC();
        ServiceD d = new ServiceD();

        d.setServiceC(c);
        c.setServiceD(d);
    }

}
