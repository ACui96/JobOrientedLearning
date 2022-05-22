package Interview.zoom20220606;

/**
 * @author Acui
 * @date 2022年06月06日 19:53
 */
public class Demo implements Base {
    public static void main(String[] args) {
        int i = 1;
        Demo demo = new Demo();
        i = demo.k;
        i = Demo.k;
        i = Base.k;
        System.out.println(i);
    }
}
