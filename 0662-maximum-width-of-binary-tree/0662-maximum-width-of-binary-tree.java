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
    static class pair{
        int index;
        TreeNode node;

        pair(int index, TreeNode node){
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        ArrayDeque<pair> q = new ArrayDeque<>();

        q.offer(new pair(1,root));
        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int width = q.peekLast().index - q.peekFirst().index + 1;

            max = Math.max(width,max);

            for (int i = 0; i < size; i++) {
                pair cur = q.poll();
                TreeNode curr = cur.node;
                int index = cur.index;
                
                if (curr.left != null)
                    q.offer(new pair(2*index,curr.left));

                if (curr.right != null)
                    q.offer(new pair(2*index+1,curr.right));
            }

        }
        return max;
    }
}