//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 485 👎 0


package leetcode.editor.cn;

import leetcode.editor.ds.TreeNode;

public class P572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new P572_SubtreeOfAnotherTree ().new Solution();
        // TO TEST
    }
    //Java：另一个树的子树
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return isSubtreeWithRoot(s, t) || isSubtreeWithRoot(s, t.left) || isSubtreeWithRoot(s, t.right);

        }

        private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (t == null || s == null) {
                return false;
            }
            if (t.val != s.val) {
                return false;
            }
            return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

