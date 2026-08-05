class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 1;
        int ans = 0;
        int end = nums.length;
         boolean found = false;
        // int mid = start+(end-start)/2;

        while(start<=end){
            found = false;
            int mid = start+(end-start)/2;
            int sum =0;
           
            for(int i= 0; i<nums.length ; i++){
               sum+= nums[i];
               if(i>=mid){
                sum -= nums[i-mid];
               }
            
             if(i >= mid - 1 && sum >= target){
                found = true;
                break;
             }

        }
        if(found){
            ans = mid;
            end = mid-1;
        }
        else{
           start = mid+1;
        }
    }
   
return ans;
}

}