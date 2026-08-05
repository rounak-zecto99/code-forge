class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<4){
            return list;
        }
        
        for(int first=0; first<nums.length; first++){
            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            long target2 = target - nums[first];

            for(int second=first+1; second<nums.length; second++){
                if(second>first+1 && nums[second] == nums[second-1]){
                    continue;
            }
            long target3 = target2 - nums[second];
            int start = second+1;
            int end = nums.length-1;
            
            while(start<end){
                long sum = nums[start] + nums[end];

                if(sum == target3){
                    List <Integer> row = new ArrayList<>();
                    row.add(nums[first]);
                    row.add(nums[second]);
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
               else if(sum<target3){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        }
        return list;
    }
}