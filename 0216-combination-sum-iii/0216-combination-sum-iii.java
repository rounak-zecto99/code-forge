class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),k,n,1);
        return list;
    }
    public void helper(List<List<Integer>> list,List <Integer> row, int k, int n,int index){
         if(row.size() == k && 0 == n ){
            list.add(new ArrayList<>(row));
            return;
         }
         if(row.size() > k || n < 0 ) return;

        for(int i= index ; i<=9 ; i++){
            row.add(i);
            helper(list,row,k,n-i,i+1);
            row.remove(row.size()-1);
        }

    }
}