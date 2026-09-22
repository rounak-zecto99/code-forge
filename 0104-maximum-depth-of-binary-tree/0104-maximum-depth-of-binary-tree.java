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
    static int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;

        if(root == null){
            return depth;
        }
        helper(root,0);
        return depth;
    }
    public void helper(TreeNode root,int curr){
        if(root == null){
            depth = Math.max(depth,curr);
            return;
        }
        helper(root.left,curr+1);
        helper(root.right,curr+1);
    }
}