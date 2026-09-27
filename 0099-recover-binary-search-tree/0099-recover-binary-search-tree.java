class Solution {
    TreeNode first;
    TreeNode prev;
    TreeNode middle;
    public void recoverTree(TreeNode root) {
        if(root == null)
        return;

        helper(root);

        int t = first.val;
        first.val = middle.val;
        middle.val = t;
    }
    public void helper(TreeNode root){
        if(root == null)
        return;

        helper(root.left);

        if(prev !=null && root.val < prev.val ){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                middle = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}