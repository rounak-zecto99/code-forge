class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum =0;
        for(int n:cardPoints){
            sum+=n;
        }
        int left=0;
        int ans =0;
        int cursum=0;
        int window = cardPoints.length -k;
        for(int i=0; i<cardPoints.length;i++){
            cursum+=cardPoints[i];

            if((i-left+1)>window){
                cursum-=cardPoints[left++];
            }
            if((i-left+1)==window)
            ans = Math.max(ans,sum-cursum);
        }
        return ans;
    }
}