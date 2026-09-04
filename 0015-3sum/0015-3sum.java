class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[0]>0)
        return list;
        
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1])
            continue;

            int target = -nums[i];
            int start = i+1;
            int end = n-1;

            while(start<end){
                if(nums[start]+nums[end] == target){
                    List<Integer> row = new ArrayList<>();
                    row.add(-target);
                    row.add(nums[start]);
                    row.add(nums[end]);
                    list.add(row);
                    start++;
                    end--;

                    while(start<end && nums[start] == nums[start-1]){
                        start++;
                    }
                    while(start<end && nums[end] == nums[end+1]){
                        end--;
                    }
                }
                else if(nums[start]+nums[end] < target){
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