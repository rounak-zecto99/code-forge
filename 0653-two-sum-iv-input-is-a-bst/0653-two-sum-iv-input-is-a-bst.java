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
    ArrayList<Integer> ans = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        helper(root);
        int left = 0;
        int right = ans.size()-1;

        while(left < right){
            if(ans.get(left)+ans.get(right)<k){
                left++;
            }
            else if(ans.get(left)+ans.get(right)>k){
                right --;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public void helper(TreeNode root){
        if(root == null)
        return;
        
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}