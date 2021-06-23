package JavaBasic.Java基础.jicheng;

/**
 * @author Acui
 * @date 2021年06月18日 15:57
 * 重载
 */
public class OverloadingExample {
    public void show(int x) {
        System.out.println(x);
    }

    public void show(int x, String y) {
        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        OverloadingExample e = new OverloadingExample();
        e.show(1);
        e.show(1, "2");
    }
}
