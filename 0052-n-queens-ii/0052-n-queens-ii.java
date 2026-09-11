class Solution {
    public int totalNQueens(int n) {
        // int [] queens = new int[n];
        int queens = 0;
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];

        return helper(column,diag1,diag2,queens,0);
    }
    public int helper(boolean[] column,boolean[] diag1,boolean[] diag2,int queens,int row){
        if(row == column.length){
            return 1;
        }
        int ways = 0;

        for(int col=0; col<column.length; col++){
            if(column[col]||diag1[row + col]||diag2[row - col + column.length -1])
            continue;
            column[col] = true;
            diag1[row + col] = true;
            diag2[row - col + column.length -1] = true;

            queens++;
            ways+= helper(column,diag1,diag2,queens,row+1);
            
            queens--;
            column[col] = false;
            diag1[row + col] = false;
            diag2[row - col + column.length -1] = false;
        }
        return ways;
    }
}