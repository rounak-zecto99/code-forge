class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
           helper(list,new ArrayList<>(),candidates,target,0);
           return list;
    }
    public void helper(List<List<Integer>> list ,List<Integer>row, int[] candidates, int target, int index){
        if(target == 0){
            list.add(new ArrayList<>(row));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=index; i<candidates.length ; i++){
             row.add(candidates[i]);
             helper(list,row,candidates,target-candidates[i],i);
             row.remove(row.size()-1);
        }
    }
}