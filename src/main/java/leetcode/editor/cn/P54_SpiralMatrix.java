//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 639 👎 0


package leetcode.editor.cn;

//螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            if (matrix == null || m == 0 || n == 0) {
                return ret;
            }
            int total = m * n;
            boolean[][] visited = new boolean[m][n];
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direIndex = 0;
            int row = 0, column = 0;
            for (int i = 0; i < total; i++) {
                ret.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[direIndex][0], nextColumn = column + directions[direIndex][1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || visited[nextRow][nextColumn]) {
                    direIndex = (direIndex + 1) % 4;
                }
                row += directions[direIndex][0];
                column += directions[direIndex][1];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}