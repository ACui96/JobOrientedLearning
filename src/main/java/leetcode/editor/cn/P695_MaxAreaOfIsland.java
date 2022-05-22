//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 564 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Stack;

public class P695_MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695_MaxAreaOfIsland ().new Solution();
        // TO TEST
    }
    //Java：岛屿的最大面积
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            m = grid.length;
            n = grid[0].length;

            int maxArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
            return maxArea;
        }

        private int dfs(int[][] grid, int r, int c) {
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
                return 0;
            }
            grid[r][c] = 0;
            int area = 1;
            for (int[] d : direction) {
                area += dfs(grid, r + d[0], c + d[1]);
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

