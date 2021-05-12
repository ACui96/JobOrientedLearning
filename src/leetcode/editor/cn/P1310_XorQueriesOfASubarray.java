//有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。 
//
// 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
//本次查询的结果。 
//
// 并返回一个包含给定查询 queries 所有结果的数组。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//输出：[2,7,14,8] 
//解释：
//数组中元素的二进制表示形式是：
//1 = 0001 
//3 = 0011 
//4 = 0100 
//8 = 1000 
//查询的 XOR 值为：
//[0,1] = 1 xor 3 = 2 
//[1,2] = 3 xor 4 = 7 
//[0,3] = 1 xor 3 xor 4 xor 8 = 14 
//[3,3] = 8
// 
//
// 示例 2： 
//
// 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//输出：[8,0,4,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10^4 
// 1 <= arr[i] <= 10^9 
// 1 <= queries.length <= 3 * 10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] <= queries[i][1] < arr.length 
// 
// Related Topics 位运算 
// 👍 59 👎 0


package leetcode.editor.cn;

public class P1310_XorQueriesOfASubarray {
    public static void main(String[] args) {
        Solution solution = new P1310_XorQueriesOfASubarray ().new Solution();
        // TO TEST
        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] ret = solution.xorQueries(arr, queries);
        for (int i : ret) {
            System.out.println(i);
        }
    }
    //Java：子数组异或查询
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力
         * @author Acui
         * @date 2021/5/12 8:42
         * @param arr
         * @param queries
         * @return int[]
         */
        public int[] xorQueries1(int[] arr, int[][] queries) {
            int n = queries.length;
            int[] ret = new int[n];
            int L = 0, R = 0;
            for (int j = 0; j < n; j++) {
                L = queries[j][0];
                R = queries[j][1];
                int temp = 0;
                for (int i = L; i <= R; i++) {
                    temp ^= arr[i];
                }
                ret[j] = temp;
            }
            return ret;
        }

        /**
         * 前缀和解法
         * @author Acui
         * @date 2021/5/12 8:41
         * @param arr
         * @param queries
         * @return int[]
         */
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length + 1;
            int[] pre = new int[n];
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] ^ arr[i - 1];
            }
            int[] ret = new int[queries.length];
            int i = 0;
            for (int[] query : queries) {
                ret[i++] = pre[query[0]] ^ pre[query[1] + 1];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

