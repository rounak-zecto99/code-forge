class Solution {
    public int close(int[]nums, int newtarget,int start, int end){
         int  sum = nums[start] + nums[end];
         int ans =sum;
          while(start<end){
             sum = nums[start] + nums[end];
            
               if(Math.abs(newtarget - sum) <= Math.abs(newtarget - ans)){
                ans = sum;
             }
               if(sum < newtarget){
                start ++;
              }
              else{
                end--;
              }
            }
            return ans;
    }
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
        int finalsum =  nums[0]+nums[1]+nums[nums.length-1];;
        for(int i=0;i<nums.length-2; i++){
            int newtarget = target - nums[i];
              
            int start = i+1;
            int end = nums.length-1;
        
            int newval = close(nums, target-nums[i],start,end);
            

            if(Math.abs(target -(nums[i]+newval) )<=Math.abs(target - finalsum)){
              finalsum = nums[i]+newval;
            }
        }

            return finalsum;         
           
        }
    }