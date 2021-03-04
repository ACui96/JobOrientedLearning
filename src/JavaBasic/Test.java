package JavaBasic;

public class Test {
    static {
        System.out.println("static block");
    }
    public static void main(String[] args) {
        Test test = new Test();
        Test test2 = new Test();
        String s = new String("123");
        int hash = s.hashCode();

    }
}
