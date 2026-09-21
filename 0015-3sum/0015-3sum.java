class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i<nums.length-2;i++){
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int start = i+1;
            int end = nums.length-1;

            while(start<end){
                if(nums[start]+nums[end] ==  target){
                    List<Integer> row = new ArrayList<>();
                    row.add(-target); 
                    row.add(nums[start]);
                    row.add(nums[end]);
                    list.add(row);
                    start++;
                    end--;
                  while (start < end && nums[start] == nums[start - 1]){
                    start++;}
                
                while (start < end && nums[end] == nums[end + 1]){
                     end--;}
            }
                else if(nums[start]+nums[end]< target){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return list;
    }
}