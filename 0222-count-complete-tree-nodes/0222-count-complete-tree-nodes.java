class Solution {
    public int countNodes(TreeNode root) {

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return (1<<leftHeight) -1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int getLeftHeight(TreeNode root){
        
        int h=0;

        while(root != null){
            root = root.left;
            h++;
        }

        return h;
    }

        public int getRightHeight(TreeNode root){
        
        int h=0;

        while(root != null){
            root = root.right;
            h++;
        }

        return h;
    }
}