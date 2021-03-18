package leetcode.editor.test;

import java.util.*;


public class Test {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(2, 2);
        map.put(4, 4);
        //{1=1, 2=2, 3=3, 4=4}
        System.out.println(map);


        LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<>();
        lmap.put(1, 1);
        lmap.put(3, 1);
        lmap.put(4, 1);
        lmap.put(2, 1);
        //{1=1, 3=1, 4=1, 2=1}
        System.out.println(lmap);

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(1, 1);
        tmap.put(2, 1);
        tmap.put(4, 1);
        tmap.put(3, 1);
        System.out.println(tmap);
    }
}

