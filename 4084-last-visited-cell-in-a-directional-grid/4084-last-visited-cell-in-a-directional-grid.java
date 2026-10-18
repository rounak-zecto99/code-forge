class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;

        int [] ans = dfs(0,0,grid,vis);
        return ans;
    }
    int[] dfs(int row,int col, char[][] grid, boolean[][] vis){

        char next = grid[row][col];
        vis[row][col] = true;
        

        if(next == 'U' && row > 0 && !vis[row - 1][col])
        return dfs(row - 1,col,grid,vis);

        if(next == 'D' && row + 1 < grid.length && !vis[row + 1][col])
        return dfs(row + 1,col,grid,vis);

        if(next == 'L' && col > 0 && !vis[row][col-1])
        return dfs(row,col-1,grid,vis);

        if(next == 'R' && col + 1 < grid[0].length && !vis[row][col+1])
        return dfs(row,col + 1,grid,vis);

        return new int[]{row,col};

    }
}