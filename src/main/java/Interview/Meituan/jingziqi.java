package Interview.Meituan;


import java.util.ArrayList;
import java.util.List;

class Solution1 {
    List<Integer> path = new ArrayList<>();
    public int func(int n) {

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = i + 1;
        }
        dfs(colors, 0);

        return path.size();
    }

    private void dfs(int[] colors, int k) {
        if (k == colors.length) {

        }
    }

}

/**
 * @author Acui
 * @date 2022年04月09日 17:05
 */
public class jingziqi {
    public static void main(String[] args) {
        System.out.println(new Solution1().func(2));
    }
}
