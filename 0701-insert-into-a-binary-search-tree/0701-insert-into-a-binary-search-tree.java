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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        
        if(root == null){
            return new TreeNode(val);
        }
        while(true){
            if(root.val < val){
                if(root.right == null){
                    TreeNode ins = new TreeNode(val);
                    root.right = ins;
                    break;
                }
                else{
                    root = root.right;
                }
            }
            else{
                if(root.left == null){
                    TreeNode ins = new TreeNode(val);
                    root.left = ins;
                    break;
                }
                else{
                    root = root.left;
                }
            }
        }
        return cur;
    }
}