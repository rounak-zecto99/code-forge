class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) return -1;

        int left = height(node.left);
        int right = height(node.right);

        int h = 1 + Math.max(left, right);

        if (result.size() == h) {
            result.add(new ArrayList<>());
        }

        result.get(h).add(node.val);
        return h;
    }
}