package leetcode.editor.test;

import java.util.*;

/**
 * @author Acui
 * @date 2021年12月19日 15:37
 */
public class dfsTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        dfsTest solution = new dfsTest();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }


        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         Deque<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;

                    System.out.println("  递归之前 => " + path);
                    dfs(nums, len, depth + 1, path, used, res);

                    used[i] = false;
                    path.removeLast();
                    System.out.println("递归之后 => " + path);
                }
            }
        }





}
