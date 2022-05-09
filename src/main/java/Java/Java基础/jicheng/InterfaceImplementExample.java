package Java.Java基础.jicheng;

/**
 * @author Acui
 * @date 2021年06月18日 14:35
 */
public class InterfaceImplementExample implements InterfaceExample {

    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();
        System.out.println(InterfaceExample.x);
    }
}
