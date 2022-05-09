package Interview.Common;

/**
 * @author Acui
 * @date 2022年04月22日 15:42
 */
public class Util {
    /**
     * 根据字符串数组创建二叉树
     * [1,2,3,4,5,#,6,#,#,7,8] ->
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4   5   6
     *    / \
     *   7   8
     * @author Acui
     * @date 2022/4/22 15:47
     * @param vals 字符串数组
     * @param start 开始位置
     * @return Interview.Common.TreeNode
     */
    public static TreeNode createTree(String[] vals, int start) {
        if (vals[start].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(vals[start]));
        int lnode = 2 * start + 1;
        int rnode = 2 * start + 2;
        if (lnode > vals.length - 1) {
            root.left = null;
        } else {
            root.left = createTree(vals, lnode);
        }
        if (rnode > vals.length - 1) {
            root.right = null;
        } else {
            root.left = createTree(vals, rnode);
        }
        return root;
    }
}
