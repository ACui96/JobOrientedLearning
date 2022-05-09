package Interview.huzhe20220422;

import Interview.Common.TreeNode;

import static Interview.Common.Util.createTree;

/**
 * @author Acui
 * @date 2022年04月22日 9:33
 */
public class Q2 {

    public static void main(String[] args) {
        String[] vals = new String[]{"1", "#", "2", "#", "#", "#", "3"};
        TreeNode root = createTree(vals,0);
        firstOrder(root);
    }
    private static void firstOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        firstOrder(root.left);
        firstOrder(root.right);
    }
}
