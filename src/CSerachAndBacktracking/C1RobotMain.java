package CSerachAndBacktracking;

public class C1RobotMain {
    public static void main(String[] args) {
        C1Robot solution = new C1Robot();
        int m  = 2, n = 3, k = 1;
        int res = solution.movingCount1(m, n, k);
        System.out.println(res);
    }
}
