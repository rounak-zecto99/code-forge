class Solution {
    public int minSumOfLengths(int[] arr, int target) {
    int INF = Integer.MAX_VALUE;
    int n = arr.length;
    int []dp = new int[n+1];
    dp[0] = INF;
    int left =0;
    int sum =0;
    int minLen = INF;

    for(int right=0; right<n; right++){
        sum += arr[right];

        while(sum > target){
            sum -= arr[left++];
        }
        int current_length = INF;

        if(sum == target)
        current_length = right - left + 1;

        if(current_length != INF && dp[left] != INF)
        minLen = Math.min(minLen,current_length+dp[left]);

        dp[right+1] = Math.min(current_length,dp[right]);
    }
    return minLen == INF?-1:minLen;
    }
}