package Interview.NetEasy20220416;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    private static List<List<Long>> ret = new ArrayList<>();
    private static LinkedList<Long> path = new LinkedList<>();
    private static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long k = sc.nextLong();
        Long x = sc.nextLong();
        dfs(n, k, x, 0L, 1L);
        if (flag) {
            List<Long> list = ret.get(0);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            System.out.print(-1);
        }
    }

    private static void dfs(Long n, Long k, Long x, Long sum, Long begin) {
        if (path.size() == n) {
            if (sum == x) {
                flag = true;
                ret.add(new ArrayList<>(path));
            }
            return;
        }
        if (flag) {
            return;
        }
        for (Long i = begin; i <= k; i++) {
            sum += i;
            path.add(i);
            dfs(n, k, x, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

}
