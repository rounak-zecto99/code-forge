/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        return sum(root) != -1;
    }
    public int sum(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null)
        return root.data;
        
        int left = sum(root.left);
        
        if(left == -1)
        return -1;
        
        int right = sum(root.right);
        
        if(right == -1)
        return -1;
        
        if(root.data != left+right){
            return -1;
        }
        return root.data;
    }
}