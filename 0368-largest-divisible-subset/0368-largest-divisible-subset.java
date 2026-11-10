class Solution {
    List<Integer>[][] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        dp = new ArrayList[n][n + 1];
        Arrays.sort(nums);
        return helper(nums, 0, -1);
    }

    public List<Integer> helper(int[] nums, int index, int prev) {

        if (index == nums.length) {
            return new ArrayList<>();
        }

        if (dp[index][prev + 1] != null) {
            return dp[index][prev + 1];
        }

        List<Integer> a = helper(nums, index + 1, prev);

        List<Integer> b = new ArrayList<>();

        if (prev == -1 || nums[index] % nums[prev] == 0) {
            b.add(nums[index]);

            b.addAll(helper(nums, index + 1, index));
        }
        return dp[index][prev + 1] = a.size() > b.size() ? a : b;
    }

}