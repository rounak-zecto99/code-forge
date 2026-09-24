class Solution {
	static class pair {
		long ind;
		Node node;
		
		pair(long ind, Node node) {
			this.ind = ind;
			this.node = node;
		}
	}
	public int maxWidth(Node root) {
		if (root == null)
			return 0;
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(root);
		
		int max = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			max = Math.max(max, size);
			
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				
				if (cur.left != null)
					q.offer(cur.left);
				
				if (cur.right != null)
					q.offer(cur.right);
			}
		}
		
		return max;
	}
}
