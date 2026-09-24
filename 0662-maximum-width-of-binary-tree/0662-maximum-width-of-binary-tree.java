class Solution {
    static class Pair {
        long index;
        TreeNode node;

        Pair(long index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, root));

        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long first = q.peekFirst().index;
            long last = q.peekLast().index;

            max = Math.max(max, (int)(last - first + 1));

            // Normalize indices for this level
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();

                long index = cur.index - first;

                if (cur.node.left != null)
                    q.offer(new Pair(2 * index, cur.node.left));

                if (cur.node.right != null)
                    q.offer(new Pair(2 * index + 1, cur.node.right));
            }
        }

        return max;
    }
}