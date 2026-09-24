class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    void track_parent(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                map.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        track_parent(root);
        TreeNode target = target(root,start);
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(target);
        visited.add(target);

        int time = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();

                if(cur.left != null && visited.add(cur.left)){
                    q.offer(cur.left);
                }
                if(cur.right != null && visited.add(cur.right)){
                    q.offer(cur.right);
                }
                TreeNode parent = map.get(cur);

                if(parent != null && visited.add(parent)){
                    q.offer(parent);
                }
            }
            time++;
        }
        return time;
    }

    TreeNode target(TreeNode root, int start) {
        if (root == null || root.val == start)
            return root;

        TreeNode left = target(root.left, start);
        TreeNode right = target(root.right, start);

        return left == null ? right : left;
    }
}