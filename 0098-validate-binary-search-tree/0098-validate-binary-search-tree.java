class Solution {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root == null)
        return true;

        boolean flag = helper(root.left);

        if(!flag)
        return false;

        if(prev>=root.val)
        return false;
        else
        prev = root.val;

        flag = helper(root.right);
        return flag;
    }
}