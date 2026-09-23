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
    static class Tuple{
        int row;
        TreeNode node;

        Tuple(int row, TreeNode node){
            this.row = row;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        if(root == null)
        return list;

        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(0,root));

        while(!q.isEmpty()){
            Tuple cur = q.poll();

            TreeNode node = cur.node;
            int row = cur.row;

            map.put(row,node.val);

            if(node.left != null){
                q.offer(new Tuple(row+1,node.left));
            }
            if(node.right != null){
                q.offer(new Tuple(row+1,node.right));
            }
        }

        for(int val : map.values()){
            list.add(val);
        }
        return list;
    }
}