public class Codec {

    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("# ");
                continue;
            }
            sb.append(cur.val + " ");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "")
            return null;

        String[] val = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.offer(root);
        int i = 0;

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (!val[++i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                parent.left = left;
                q.offer(left);
            }
            if (!val[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
