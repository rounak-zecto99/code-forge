class Solution {
	public int maximumPoints(int mat[][]) {
		int ans = -1;
		int [][] dp = new int[3][mat.length];
		for (int[]ar:dp)
			Arrays.fill(ar, -1);
			
			
		for (int i = 0; i<3; i++) {
			ans = Math.max(ans, mat[0][i]+helper(mat, i, 1,dp));
		}
		return ans;
	}
	public int helper(int mat[][], int skip, int index, int[][]dp) {
		// if im taking current whats the best answer next can guarantee
		
		if (index == mat.length) {
			return 0;
		}
		if(dp[skip][index]!=-1)
          return dp[skip][index];
          
		int ans = 0;
		int right = Integer.MIN_VALUE;
		int left = Integer.MIN_VALUE;
		boolean sent = false;
		
		for (int i = 0; i<3; i++) {
			if (i == skip)
				continue;
			
			if (!sent) {
				sent = true;
				left = mat[index][i]+ helper(mat, i, index + 1,dp);
			}
			else {
				right = mat[index][i]+ helper(mat, i, index + 1,dp);
				
			}
		}
		ans += Math.max(left, right);
		return dp[skip][index] = ans;
		
	}
}
