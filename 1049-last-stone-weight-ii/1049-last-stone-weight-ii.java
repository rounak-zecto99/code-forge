class Solution {
    int k;
    
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int x : stones) {
            sum += x;
        }
        this.k = sum >> 1;

        int val = helper(stones, stones.length - 1, 0);

        return sum - (val<<1);

    }

    public int helper(int[] stones, int index, int sum) {

        if (sum == k) {
            return sum;
        }

        if (index < 0 )
          return sum;

        int take = sum;
        if(sum+stones[index]<=k)
        take = helper(stones, index - 1, sum + stones[index]);

        int NoTake = helper(stones, index - 1, sum);

        return Math.max(take,NoTake);
    }
}