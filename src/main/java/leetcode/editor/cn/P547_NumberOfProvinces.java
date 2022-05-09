//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 632 👎 0


package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;

public class P547_NumberOfProvinces {
    public static void main(String[] args) {
        Solution2 solution = new P547_NumberOfProvinces ().new Solution2();
        // TO TEST

        int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(matrix));

    }
    //Java：省份数量
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int N;

        public int findCircleNum(int[][] M) {
            N = M.length;
            int circleNum = 0;
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(M, i, visited);
                    circleNum++;
                }
            }
            return circleNum;
        }

        private void dfs(int[][]M, int i, boolean[] visited) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(M, j, visited);
                }
            }
        }
    }

    /**
     * BFS
     * @author Acui
     * @date 2021/9/30 9:29
     */
    class Solution2{
        public int findCircleNum(int[][] M) {
            int N = M.length;
            boolean[] visited = new boolean[N];
            int circleNum = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    queue.offer(i);
                    while (!queue.isEmpty()) {
                        int j = queue.poll();
                        visited[j] = true;
                        for (int k = 0; k < N; k++) {
                            if (M[j][k] == 1 && !visited[k]) {
                                queue.offer(k);
                            }
                        }
                    }
                    circleNum++;
                }
            }
            return circleNum;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}

