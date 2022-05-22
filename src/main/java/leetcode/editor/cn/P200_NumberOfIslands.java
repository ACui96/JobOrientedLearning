//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1350 👎 0


package leetcode.editor.cn;

public class P200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200_NumberOfIslands ().new Solution();
        // TO TEST
    }
    //Java：岛屿数量
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            m = grid.length;
            n = grid[0].length;
            int ret = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != '0') {
                        dfs(grid, i, j);
                        ret++;
                    }
                }
            }
            return ret;
        }

        private void dfs(char[][] grid, int r, int c) {
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
                return;
            }
            grid[r][c] = '0';
            for (int[] d : direction) {
                dfs(grid, r + d[0], c + d[1]);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}

