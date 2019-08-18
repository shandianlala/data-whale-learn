package club.sdll.datawhale.learn.task5;

/**
 * @author shandianlala@gmail.com
 * @description TODO
 * @since 2019-08-18 19:15
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempRight = root.right;
        //递归调用
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
