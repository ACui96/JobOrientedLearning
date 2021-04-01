//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 351 👎 0


package leetcode.editor.cn;

//搜索二维矩阵

public class P74_SearchA2dMatrix{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(solution.searchMatrixII(matrix, target));

    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            if(m == 0 || matrix == null) return false;
            int[] arr = new int[m * n];
            int idx = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    arr[idx++] = matrix[i][j];
                }
            }
            int lo = 0, hi = arr.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(arr[mid] == target) {
                    return true;
                } else if(arr[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return false;
        }

        /**
         * 简化版
         */
        public boolean searchMatrixII(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int lo = 0, hi = m * n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int x = matrix[mid / n][mid % n];
                if (x == target) {
                    return true;
                } else if (x > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}