class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int [][] copy = new int [n][2];

        for(int i=0; i<n; i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        Arrays.sort(copy,(a,b) -> a[0]-b[0]);
        int [][] copy1 = Arrays.copyOfRange(copy,n-k,n);
        Arrays.sort(copy1,(a,b) -> a[1]-b[1]);

        int [] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = copy1[i][0];
        }
        return ans;
    }
}