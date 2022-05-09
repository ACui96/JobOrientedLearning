//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 327 👎 0


package leetcode.editor.cn;

//螺旋矩阵 II

public class P59_SpiralMatrixIi{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            if(n == 0) return new int[0][0];
            int[][] ret = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direcIndex = 0;
            int row = 0, column = 0;
            for (int i = 1; i < n * n; i++) {
                ret[row][column] = i;
                visited[row][column] = true;
                int nextRow = row + directions[direcIndex][0], nextColumn = column + directions[direcIndex][1];
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || visited[nextRow][nextColumn]) {
                    direcIndex = (direcIndex + 1) % 4;
                }
                row += directions[direcIndex][0];
                column += directions[direcIndex][1];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}