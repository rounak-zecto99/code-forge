class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        int m = Math.min(need1, need2);

        long pairCost = Math.min(costBoth, (long) cost1 + cost2);

        long ans = pairCost * m;

        ans += (long) (Math.min(costBoth, cost1)) * (need1 - m);
        ans += (long) (Math.min(costBoth, cost2)) * (need2 - m);

        return ans;
    }
}
