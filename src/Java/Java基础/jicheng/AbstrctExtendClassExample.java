package Java.Java基础.jicheng;

/**
 * @author Acui
 * @date 2021年06月18日 11:16
 */
public class AbstrctExtendClassExample extends AbstractClassExample {

    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        //AbstractClassExample ac1 = new AbstractClassExample(); //AbstractClassExample' is abstract; cannot be instantiated
        AbstrctExtendClassExample ac2 = new AbstrctExtendClassExample();
        ac2.func1();
        ac2.func2();
    }
}
