class Solution {
     int ans = Integer.MAX_VALUE;
     Integer pred = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }
    void inorder(TreeNode root){
        if( root == null )
        return;

        inorder(root.left);
        if( pred != null )
        ans = Math.min(ans, root.val - pred);
        pred = root.val;
        inorder(root.right);
    }
}