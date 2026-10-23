class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    int inf = (int) 1e9;
    int[][] dp;

    static {
        boolean[] prime = new boolean[8000];

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                list.add(i);

                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public int minNumberOfPrimes(int target, int end) {

        dp = new int[target + 1][end];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        int ans = helper(target, end - 1);
        return ans == inf ? -1 : ans;
    }

    public int helper(int target, int index) {

        if (index == 0) {
            if (target % list.get(0) == 0) {
                return target / list.get(0);
            } else {
                return inf;
            }
        }

        if (dp[target][index] != -1)
            return dp[target][index];

        int noTake = helper(target, index - 1);

        int take = inf;

        if (target >= list.get(index)) {
            take = 1 + helper(target - list.get(index), index);
        }

        return dp[target][index] = Math.min(take, noTake);
    }
}