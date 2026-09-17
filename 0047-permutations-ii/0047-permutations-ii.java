class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean []used = new boolean[nums.length];
        helper(list,new ArrayList<>(),nums,used);
        return list;
    }

    public void helper(List<List<Integer>> list, List<Integer> row,int[] nums, boolean []used){
        if(row.size() == nums.length){
            list.add(new ArrayList<>(row));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i])
            continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1])
            continue;

            used[i] = true;

            row.add(nums[i]);
            helper(list,row,nums,used);
            row.remove(row.size()-1);
            used[i] = false;
        }
    }
}