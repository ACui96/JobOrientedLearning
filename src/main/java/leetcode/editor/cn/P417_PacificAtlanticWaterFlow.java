//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 291 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new P417_PacificAtlanticWaterFlow ().new Solution();
        // TO TEST
    }
    //Java：太平洋大西洋水流问题
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m, n;
        private int[][] heights;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            if (m == 0) {
                return null;
            }
            n = heights[0].length;
            this.heights = heights;
            boolean[][] canReachP = new boolean[m][n];
            boolean[][] canReachA = new boolean[m][n];
            List<List<Integer>> ret = new ArrayList<>();
            for (int r = 0; r < m; r++) {
                dfs(r, 0,canReachP);
                dfs(r, n - 1,canReachA);

            }
            for (int c = 0; c < n; c++) {
                dfs(0, c, canReachP);
                dfs(m - 1, c, canReachA);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachA[i][j] && canReachP[i][j]) {
                        ret.add(Arrays.asList(i, j));
                    }
                }
            }
            return ret;
        }

        private void dfs(int r, int c, boolean[][] canReach) {
            if (canReach[r][c]) {
                return;
            }
            canReach[r][c] = true;
            for (int[] d : directions) {
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || heights[r][c] > heights[nextR][nextC]) {
                    continue;
                }
                dfs(nextR, nextC, canReach);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

