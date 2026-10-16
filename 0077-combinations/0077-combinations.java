class Solution {
    List<List<Integer>> list;
    int n; 
    int k;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        this.n = n;
        this.k = k;

        helper(new ArrayList<>(),1);
        return list;
    }
    void helper(List<Integer> row,int index){
        if(row.size() == k){
            list.add(new ArrayList<>(row));
            return;
        }

        for(int i=index; i<=n ; i++){
            row.add(i);
            helper(row,i+1);
            row.remove(row.size()-1);
        }
    }

}