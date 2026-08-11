class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list= new ArrayList<>();   
        helper(list,new ArrayList<>(),candidates,target,0);
         return list;       
    }
    public void helper(List<List<Integer>> list,List<Integer> row, int []candidates, int target, int index){
           if(target == 0){
            list.add(new ArrayList<>(row));
            return;
           }
           if (index == candidates.length || target < 0){
            return;
           }
           for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            row.add(candidates[i]);
             helper(list,row,candidates,target-candidates[i],i+1);
             row.remove(row.size()-1);
           }
    }
}