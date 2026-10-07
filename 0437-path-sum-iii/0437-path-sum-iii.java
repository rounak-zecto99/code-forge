class Solution {
    Map<Long, Integer> map;
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);

        helper(root, targetSum, 0L);

        return count;
    }

    void helper(TreeNode root, int targetSum, long sum) {
        if (root == null)
            return;

        sum += root.val;

        count += map.getOrDefault(sum - targetSum, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);

        // Backtrack
        map.put(sum, map.get(sum) - 1);
    }
}