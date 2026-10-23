class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int inf = (int) 1e9;
    int[][] dp;

    public int minNumberOfPrimes(int target, int end) {
        list.clear();

        boolean[] prime = new boolean[target + 1];

        for (int i = 2; i <= target; i++) {
            if (!prime[i]) {
                list.add(i);

                for (int j = i * i; j <= target; j += i) {
                    prime[j] = true;
                }

                if (list.size() == end) break;
            }
        }

        if (list.isEmpty()) return -1;

        dp = new int[target + 1][list.size()];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        int ans = helper(target, list.size() - 1);
        return ans >= inf ? -1 : ans;
    }

    public int helper(int target, int index) {
        if (index == 0) {
            return target % 2 == 0 ? target / 2 : inf;
        }

        if (dp[target][index] != -1) {
            return dp[target][index];
        }

        int noTake = helper(target, index - 1);
        int take = inf;

        if (target >= list.get(index)) {
            take = 1 + helper(target - list.get(index), index);
        }

        return dp[target][index] = Math.min(take, noTake);
    }
}