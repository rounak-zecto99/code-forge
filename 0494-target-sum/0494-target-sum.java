class Solution {
    public int findTargetSumWays(int[] arr, int diff) {
		int count = 0;
		int n = arr.length;
		int totalSum = 0;
		
            for (int x : arr) {
                totalSum += x;
             }
             
        if(((totalSum - diff)&1) != 0 || Math.abs(diff) > totalSum)
        return 0;
        
        int target = (totalSum + diff) >> 1;
		
		int [][] dp = new int[n][totalSum + 1];
		
		if (arr[0] == 0) {
			dp[0][0] = 2;
		}
		else {
			dp[0][0] = 1;
			
			if (arr[0] <= totalSum)
				dp[0][arr[0]] = 1;
		}
		
		for (int index = 1; index<n; index++) {
			for (int sum = 0; sum <= totalSum; sum++) {
				dp[index][sum] = dp[index - 1][sum];
				
				if (sum >= arr[index])
					dp[index][sum] += dp[index - 1][sum - arr[index]];
			}
		}
		return dp[n-1][target];
    }
}