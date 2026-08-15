class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // boolean [][] taken = new boolean[m][n];
        int pos=0;
        char initial = word.charAt(0);

        while(pos<m*n){
            int row = pos/n;
            int col = pos%n;

            if(board[row][col] == initial){
                if(helper(board,word,1,row,col)){
                    return true;
                }
            }
            pos++;
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int index, int row, int col){
        if(index == word.length()){
            return true;
        }
        char currw = board[row][col];
        board[row][col] = '.';
        char nextword = word.charAt(index);
 
        if(row>0 && board[row-1][col] == nextword){
           if(helper(board,word,index+1,row-1,col)){
            return true;
           }
      }
         if(col>0 && board[row][col-1] == nextword){
           if(helper(board,word,index+1,row,col-1)){
            return true;
           }
        }
         if(row<board.length-1 && board[row+1][col] == nextword){
         if(helper(board,word,index+1,row+1,col)){
            return true;
           }

        }
         if(col<board[0].length-1 && board[row][col+1] == nextword){
            if(helper(board,word,index+1,row,col+1)){
            return true;
           }

        }
         board[row][col] = currw;
        return false;
    }
}