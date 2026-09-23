class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root == null)
            return ans;

        q.addLast(root);

        boolean right = false;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr;

                if (right) {
                    curr = q.removeLast();

                    if (curr.right != null)
                        q.addFirst(curr.right);

                    if (curr.left != null)
                        q.addFirst(curr.left);

                } else {
                    curr = q.removeFirst();

                    if (curr.left != null)
                        q.addLast(curr.left);

                    if (curr.right != null)
                        q.addLast(curr.right);
                }

                list.add(curr.val);
            }

            ans.add(list);
            right = !right;
        }

        return ans;
    }
}