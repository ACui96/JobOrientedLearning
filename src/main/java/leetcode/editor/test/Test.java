package leetcode.editor.test;

import java.util.*;


public class Test {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
     }

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        boolean isLeft = true;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Deque<Integer> path = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    path.addLast(node.val);
                } else {
                    path.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            isLeft = !isLeft;
            ret.add(new LinkedList<>(path));
        }
        return ret;
    }
}

