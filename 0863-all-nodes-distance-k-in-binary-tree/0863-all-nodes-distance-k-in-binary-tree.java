class Solution {

    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    void markParent(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            parent.put(root.left, root);
            markParent(root.left);
        }

        if (root.right != null) {
            parent.put(root.right, root);
            markParent(root.right);
        }
    }

    void dfs(TreeNode node, int distance, int k) {

        if (node == null || visited.contains(node))
            return;

        visited.add(node);

        if (distance == k) {
            ans.add(node.val);
            return;
        }

        dfs(node.left, distance + 1, k);
        dfs(node.right, distance + 1, k);
        dfs(parent.get(node), distance + 1, k);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        markParent(root);

        dfs(target, 0, k);

        return ans;
    }
}