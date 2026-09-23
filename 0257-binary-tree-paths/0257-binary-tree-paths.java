class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, new StringBuilder(), ans);
        return ans;
    }

    void helper(TreeNode root, StringBuilder path, List<String> ans) {
        int len = path.length();

        path.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(path.toString());
        } else {
            path.append("->");

            if (root.left != null)
                helper(root.left, path, ans);

            if (root.right != null)
                helper(root.right, path, ans);
        }

        path.setLength(len); // backtrack
    }
}