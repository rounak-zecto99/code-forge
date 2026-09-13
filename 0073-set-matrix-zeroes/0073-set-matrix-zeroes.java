class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean [] row = new boolean [r];
        boolean [] col = new boolean [c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // System.out.println(Arrays.toString(row));
        // System.out.println(Arrays.toString(col));
        for(int x=0; x<r; x++){
            for(int y=0; y<c; y++){
                if(row[x]){
                    matrix[x][y] = 0;
                }
                else if(col[y]){
                    matrix[x][y] = 0;
                }
            }
        }
    }
}