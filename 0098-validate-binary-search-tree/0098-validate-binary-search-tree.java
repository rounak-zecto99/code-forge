class Solution {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
        return true;

        if(!isValidBST(root.left))
        return false;

        if(prev >= root.val)
        return false;

        prev = root.val;

        return isValidBST(root.right);
    }
}