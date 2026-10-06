class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root, int value){
        if(root.left == null && root.right == null){
            sum += value*10 + root.val;
        }
        if(root.left != null)
        helper(root.left, value*10 + root.val);

        if(root.right != null)
        helper(root.right, value*10 + root.val);
    }
}