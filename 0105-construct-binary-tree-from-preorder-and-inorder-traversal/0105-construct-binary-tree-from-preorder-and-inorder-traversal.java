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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,
                inorder,
                0,
                preorder.length - 1,
                0,
                inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int i = instart;

        while (i <= inend) {
            if (preorder[prestart] == inorder[i]) {
                break;
            }
            i++;
        }

        int leftSize = i - instart;

        root.left = helper(preorder, inorder, prestart + 1, prestart + leftSize, instart, i - 1);

        root.right = helper(preorder, inorder, prestart + leftSize + 1, preend, i + 1, inend);

        return root;
    }
}