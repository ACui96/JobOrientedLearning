package JavaBasic.Java基础;

/**
 * @author Acui
 * @date 2021年06月18日 10:02
 */
public class FinalTest {
    public static void main(String[] args) {
        final int a = 1;
        //a = 2; // Cannot assign a value to final variable 'a'

        final Dog dog = new Dog();
        dog.name = "wangwang";
    }
}
