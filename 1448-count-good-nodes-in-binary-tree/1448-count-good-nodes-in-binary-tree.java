class Solution {
    int count = 0;

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count;
    }

    void helper(TreeNode root, int prev) {
        if (root == null)
            return;

        helper(root.left, Math.max(prev, root.val));
        helper(root.right, Math.max(prev, root.val));

        if (root.val >= prev) {
            // System.out.println(root.val);
            count++;
        }
    }
}