class Solution {
    public void solveSudoku(char[][] board) {
        int n=9;
        boolean [][] rows = new boolean [n][n+1];
        boolean [][] col = new boolean [n][n+1];
        boolean [][][] grid = new boolean[3][3][n+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                int curr = board[i][j] - '0';
                if (curr > 0 && curr < 10){
                    rows[i][curr] = true;
                    col[j][curr] = true;
                    grid[i/3][j/3][curr] = true;
                }
            }
            }
            helper(board,rows,col,grid,0);
        }
        public boolean helper(char[][] board,boolean [][] rows,boolean [][] col,boolean [][][] grid,int pos){
            if(pos == 81){
                return true;
            }
            int row = pos/9;
            int c = pos%9;

            if(board[row][c]!='.') 
            return helper(board,rows,col,grid,pos+1);

            for(int curr=1; curr<=9; curr++){
                if(rows[row][curr]||col[c][curr]||grid[row/3][c/3][curr]){
                    continue;
                }
                rows[row][curr] = true;
                col[c][curr] = true;
                grid[row/3][c/3][curr] = true;

                board[row][c] = (char)(curr +'0');

                if(helper(board,rows,col,grid,pos+1)){
                    return true;
                }
                
                rows[row][curr] = false;
                col[c][curr] = false;
                grid[row/3][c/3][curr] = false;
            }
            board[row][c] = '.';
              
              return false;

        }
 }
