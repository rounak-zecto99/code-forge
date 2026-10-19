class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int small = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < target){
                small++;
            }
            else if(nums[i] == target){
                count++;
            }
        }
        while(count!=0){
            list.add(small);

            small++;
            count--;
        }
        return list;
    }
}