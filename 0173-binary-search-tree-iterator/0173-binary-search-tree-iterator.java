class BSTIterator {

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}