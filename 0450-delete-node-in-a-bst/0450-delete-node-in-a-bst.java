class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        return root;

        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode r = root.right;
            TreeNode lastLeft = findlast(root.left); //connect to the rightmost of the left
            lastLeft.right = r;

            return root.left;

        }
        return root;
    }
    TreeNode findlast(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}