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
    static class tuple {
        int col;
        int row;
        TreeNode node;

        tuple(int col, int row, TreeNode node) {
            this.col = col;
            this.row = row;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<tuple> q = new ArrayDeque<>();
        TreeMap<Integer , TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new tuple(0,0,root));

        while(!q.isEmpty()){
            tuple a = q.poll();
            int col = a.col;
            int row = a.row;
            TreeNode cur = a.node;

            map.
                computeIfAbsent(col,k -> new TreeMap<>()).
                computeIfAbsent(row,k -> new PriorityQueue<>()).
                offer(cur.val);

            if(cur.left!=null){
                q.offer(new tuple(col-1,row+1,cur.left));
            }
            if(cur.right!=null){
                q.offer(new tuple(col+1,row+1,cur.right));
            }
        }
        List<List<Integer>> list = new LinkedList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> row: map.values()){
            List<Integer> ans = new LinkedList<>();
            for(PriorityQueue<Integer> values:row.values()){
                while(!values.isEmpty()){
                    ans.add(values.poll());
                }
            }
            list.add(ans);
        }
        return list;
    }
}