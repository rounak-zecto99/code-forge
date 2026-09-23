class Solution {

    static class Tuple {
        int node;
        int row;
        int col;

        Tuple(int col, int row, int node) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Tuple> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // col -> row -> value
        nodes.sort((a, b) -> {
            if (a.col != b.col)
                return Integer.compare(a.col, b.col);

            if (a.row != b.row)
                return Integer.compare(a.row, b.row);

            return Integer.compare(a.node, b.node);
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (Tuple node : nodes) {
            int col = node.col;
            int val = node.node;

            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }

            result.get(result.size() - 1).add(val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<Tuple> nodes) {
        if (node == null)
            return;

        nodes.add(new Tuple(col, row, node.val));

        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}