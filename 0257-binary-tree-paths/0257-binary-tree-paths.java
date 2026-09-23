/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(list,new ArrayList<>(),root);
        return list;
    }
    public void helper(List<String> list, List<String> sb,TreeNode root){
        if(root.left == null && root.right == null){
            sb.add(String.valueOf(root.val));
            StringBuilder s = new StringBuilder();

            for(int i=0; i<sb.size(); i++){
                s.append(sb.get(i));
            }

            list.add(s.toString());
            sb.remove(sb.size() - 1);
            return;
        }
        if(root.left != null){
            sb.add(root.val+"->");
            helper(list,sb,root.left);
            sb.remove(sb.size() - 1);
        }

        if(root.right != null){
            sb.add(root.val+"->");
            helper(list,sb,root.right);
            sb.remove(sb.size() - 1);
        }        
    }
}