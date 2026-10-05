class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {

        helper(root,1);
        return min ==  Integer.MAX_VALUE ? 0:min;
    }
    void helper(TreeNode root, int taken){
        if(root == null)
        return;
        if(root.left == null && root.right == null){
            min = Math.min(min,taken);
        }
        helper(root.left, taken + 1);
        helper(root.right, taken +1);
    }
}