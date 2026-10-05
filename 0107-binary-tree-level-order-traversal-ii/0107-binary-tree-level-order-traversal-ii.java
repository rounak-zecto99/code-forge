class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
               List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                ans.add(curr.val);

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }
            list.add(ans);
        }
        Collections.reverse(list);
        return list;
    }
}