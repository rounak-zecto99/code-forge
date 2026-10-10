class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int x : nums){
            int index = Math.abs(x) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
            else{
                list.add(Math.abs(x));
            }
        }
        return list;
    }
}