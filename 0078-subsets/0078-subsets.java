class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List <List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>() ,nums,0); 
        return list;
    }
    public void helper(List<List<Integer>> list,List<Integer> row, int[] nums,int index){
            list.add(new ArrayList<>(row));

            for(int i= index; i<nums.length; i++){
                row.add(nums[i]);
                 helper(list,row,nums,i+1);
                 row.remove(row.size()-1);
            }
    }
}