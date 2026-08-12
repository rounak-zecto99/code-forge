class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,0,list,new ArrayList<>());
        return list;
    }
    public void helper(int[] nums,int index, List<List<Integer>> list, List<Integer> row){
            list.add(new ArrayList<>(row));

            for(int i=index; i<nums.length; i++){
                if(i>index && nums[i] == nums[i-1]) continue;
                row.add(nums[i]);
                helper(nums,i+1,list,row);
                row.remove(row.size()-1);
            }
    }
}