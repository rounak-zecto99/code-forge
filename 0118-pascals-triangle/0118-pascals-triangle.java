class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        row.add(1);

        triangle.add(row);

        helper(triangle,numRows,1);
        return triangle;
    }
    void helper(List<List<Integer>> triangle,int total,int produced){

        if(produced == total)
        return;

        List<Integer> level = new ArrayList<>();

        for(int i=0; i<=produced; i++){

            int last = i - 1 == -1 ? 0 : triangle.get(produced-1).get(i-1);
            int cur = i  == produced ? 0 : triangle.get(produced-1).get(i);

            level.add(last+cur);

        }
        triangle.add(level);
        helper(triangle,total,produced+1);
    }
}