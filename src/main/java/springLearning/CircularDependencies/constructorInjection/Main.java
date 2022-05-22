package springLearning.CircularDependencies.constructorInjection;

/**
 * @author Acui
 * @date 2022年05月22日 21:10
 */
public class Main {
    public static void main(String[] args) {
        //new ServiceA(new ServiceB(new ServiceA(......)));
    }
}
