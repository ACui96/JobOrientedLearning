package Java.Java基础.jicheng;

/**
 * @author Acui
 * @date 2021年06月18日 14:43
 */
public class SuperExample {
    protected int x;
    protected int y;

    public SuperExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void func() {
        System.out.println("SuperExample.func");
    }
}
