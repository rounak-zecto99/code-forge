class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode (preorder[start]);
        int i = start+1;
        while(i<=end){
            if(preorder[i]>root.val)
            break;
            i++;
        }
        root.left = helper(preorder,start+1,i-1);
        root.right = helper(preorder,i,end);

        return root;
    }
}