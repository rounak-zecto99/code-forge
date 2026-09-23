class Solution {

    static class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple curr = q.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, row + 1, col - 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> values : rows.values()) {
                while (!values.isEmpty())
                    column.add(values.poll());
            }

            ans.add(column);
        }

        return ans;
    }
}