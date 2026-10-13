class Solution {
    List<List<Integer>> list;

    public List<List<Integer>> findLeaves(TreeNode root) {
        list = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;

        while (dummy.left != null) {
            List<Integer> row = new ArrayList<>();
            dfs(dummy, row);
            list.add(row);
        }

        return list;
    }

    int dfs(TreeNode root, List<Integer> row) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            row.add(root.val);
            return -1;
        }
        int left = dfs(root.left, row);
        if (left == -1)
            root.left = null;

        int right = dfs(root.right, row);

        if (right == -1)
            root.right = null;

        return 0;
    }
}