class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for(int i:nums){
            end = Math.max(end,i);
        }

        while(start<end){
            int mid = start+((end-start)>>1);
            int ans = 0;

            for(int x:nums){
                ans+=(x+mid-1)/mid;
            }

            if(ans>threshold){
                start = mid+1; 
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}