class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>());
            int end=0;
         for(int i=0; i<nums.length; i++){
             int s = list.size();
             int start =0;
            if(i>0 && nums[i] == nums[i-1]){
                start = end+1;
            }
             end = s-1;
           for(int j=start ; j<s; j++){
             List<Integer> row = new ArrayList<>(list.get(j));
             row.add(nums[i]);
             list.add(row);
           }
         }
         return list;
    }
    
}