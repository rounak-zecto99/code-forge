class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = 0;
        int col = 0;
        int drow = 0;
        int dcol =0;
        int counter= 0;
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }
                else if(grid[i][j] == 2){
                    drow = i;
                    dcol = j;
                }
                else if(grid[i][j] == -1){
                    continue;
                }
                counter++;
            }
        }
       // System.out.println(counter);
        List<Integer> list = new ArrayList<>();
        helper(list,row, col, drow, dcol, grid, visited,counter,0);
        return list.size();
       
    }
    public void helper(List<Integer> list,int row, int col, int drow, int dcol, int[][] grid, boolean[][] visited, int count, int curr){


      if(visited[row][col]) return ;

       if (grid[row][col] == -1) return ;

       
       visited[row][col] = true;
           curr++;
        
        if(row == drow && col == dcol){
         if(curr == count){
            list.add(1);
            
         }
          visited[row][col] = false;
            return;
       }
       
       if(row>0){
         helper(list,row-1, col, drow, dcol, grid, visited,count,curr);
       }
        if(col>0){
        helper(list,row, col-1, drow, dcol, grid, visited,count,curr);
       }
         if(row<grid.length-1){
        helper(list,row+1, col, drow, dcol, grid, visited,count,curr);
       }
          if(col<grid[0].length-1){
         helper(list,row, col+1, drow, dcol, grid, visited,count,curr);
       }
        visited[row][col] = false;
     }
}