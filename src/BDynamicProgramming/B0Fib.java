package BDynamicProgramming;

public class B0Fib {
    public static void main(String[] args) {
        int n = 111111111;

        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
