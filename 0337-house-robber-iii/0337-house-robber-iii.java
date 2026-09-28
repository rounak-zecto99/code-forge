class Solution {
    public int rob(TreeNode root) {
        int [] result = dfs(root);
        return Math.max(result[0],result[1]);
    }
    int [] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int [] left = dfs(root.left);
        int [] right = dfs(root.right);

        int Take = root.val + left[0] + right[0];
        int notTake = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{notTake,Take};
    }
}