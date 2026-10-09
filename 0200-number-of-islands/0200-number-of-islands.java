class Solution {
    int row;
    int col;

    void dfs(int r, int c,char[][] grid){
        grid[r][c] = '0';

        if(r>0 && grid[r-1][c] == '1'){
            dfs(r-1,c,grid);
        }
        if(r+1<row && grid[r+1][c] == '1'){
            dfs(r+1,c,grid);
        }
        if(c>0 && grid[r][c-1] == '1'){
            dfs(r,c-1,grid);
        }
        if(c+1<col && grid[r][c+1] == '1'){
            dfs(r,c+1,grid);
        }
    }

    public int numIslands(char[][] grid) {
        int island = 0;

        this.row = grid.length;
        this.col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(i, j, grid);
                }
            }
        }
        return island;
    }
}