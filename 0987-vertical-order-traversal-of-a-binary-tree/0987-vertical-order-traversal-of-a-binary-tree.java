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
        TreeNode node;
        int row;
        int col;

        Tuple(int col, int row, TreeNode node){
            this.col = col;
            this.row = row;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> q = new ArrayDeque<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new Tuple(0,0,root));

        while(!q.isEmpty()){
            Tuple curr = q.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.computeIfAbsent(col,k -> new TreeMap<>()).
                computeIfAbsent(row,k -> new PriorityQueue<>()).
                offer(node.val);

            if(node.left != null)
            q.offer(new Tuple(col-1,row+1,node.left));

            if(node.right != null)
            q.offer(new Tuple(col+1,row+1,node.right));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> rows: map.values()){
            ArrayList<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq: rows.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}