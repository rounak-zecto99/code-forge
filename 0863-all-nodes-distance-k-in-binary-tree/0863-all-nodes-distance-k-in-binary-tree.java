class Solution {

    void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k)
                break;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.left != null && visited.add(curr.left))
                    q.offer(curr.left);

                if (curr.right != null && visited.add(curr.right))
                    q.offer(curr.right);

                TreeNode p = parent.get(curr);

                if (p != null && visited.add(p))
                    q.offer(p);
            }

            distance++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty())
            ans.add(q.poll().val);

        return ans;
    }
}