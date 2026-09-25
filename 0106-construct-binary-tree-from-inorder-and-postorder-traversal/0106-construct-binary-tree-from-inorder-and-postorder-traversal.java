class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(
            inorder,
            0,
            inorder.length-1,
            postorder,
            0,
            postorder.length-1
        );
    }
    public TreeNode helper(int [] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart > inend || poststart > postend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int i = instart;

        while (inorder[i] != root.val) {
            i++;
        }
        // Number of nodes in left subtree
        int leftSize = i - instart;

        root.left = helper(inorder,instart, i-1, postorder,poststart,poststart+leftSize-1);
        root.right = helper(inorder,i+1,inend,postorder,poststart+leftSize,postend-1);

        return root;
    }
}