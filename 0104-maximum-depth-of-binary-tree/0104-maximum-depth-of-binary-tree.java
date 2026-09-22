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
    public int maxDepth(TreeNode root) {
        int [] depth = {0};
        if(root == null){
            return depth[0];
        }
        helper(depth,root,0);
        return depth[0];
    }
    public void helper(int[] depth,TreeNode root,int curr){
        if(root == null){
            depth[0] = Math.max(depth[0],curr);
            return;
        }
        helper(depth,root.left,curr+1);
        helper(depth,root.right,curr+1);
    }
}