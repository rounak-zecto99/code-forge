class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int[][] dp;
    int inf = (int) 1e9;

    public int minNumberOfPrimes(int target, int end) {
        generatePrimes(end);

        dp = new int[target + 1][end];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(target, end - 1);
        return ans >= inf ? -1 : ans;
    }

    private void generatePrimes(int end) {
        int limit = 100;

        while (true) {
            boolean[] composite = new boolean[limit];

            for (int i = 2; i * i < limit; i++) {
                if (!composite[i]) {
                    for (int j = i * i; j < limit; j += i) {
                        composite[j] = true;
                    }
                }
            }

            list.clear();

            for (int i = 2; i < limit; i++) {
                if (!composite[i]) {
                    list.add(i);
                }
            }

            if (list.size() >= end) {
                list.subList(end, list.size()).clear();
                return;
            }

            limit *= 2;
        }
    }

    private int helper(int target, int index) {
        if (target == 0) return 0;

        if (index == 0) {
            return target % list.get(0) == 0
                    ? target / list.get(0)
                    : inf;
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