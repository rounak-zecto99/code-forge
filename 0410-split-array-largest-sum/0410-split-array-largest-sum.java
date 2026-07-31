class Solution {
    public int splitArray(int[] nums, int k) {
        int min= Integer.MIN_VALUE; int max =0;
        for (int i =0 ;i<nums.length ;i++){
         if(nums[i]>min){
            min = nums[i];
         }
         max += nums[i];
        }
        // int mid = min+(max-min)/2;
        while(min<max){
           int mid = min+(max-min)/2;
           int sum =0;
           int pieces =1;

            for(int i=0; i<nums.length;i++){
            if(sum+nums[i]>mid){
                 sum=nums[i];
                 pieces++;
                  if (pieces > k) 
                  break;
            }
            else{
                sum += nums[i];
                
            }
            }
            if(pieces>k){
                min = mid +1;
            }
            else{
                max = mid;
            }
            
        
    }
    return min;
    }
}