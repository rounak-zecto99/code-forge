class tuple {
    int row;
    int col;

    tuple(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<tuple> q = new ArrayDeque<>();

        for(int i = 0 ; i<m ; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    q.offer(new tuple(i,j));
                }
                else{
                    isWater[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            tuple cur = q.poll();

            int row = cur.row;
            int col = cur.col;

            if (row > 0 && isWater[row - 1][col] == -1){
                     isWater[row - 1][col] = isWater[row][col] + 1;
                    q.offer(new tuple(row - 1, col));
                }

                if (row + 1 < m && isWater[row + 1][col] == -1){
                    isWater[row + 1][col] = isWater[row][col] + 1;
                    q.offer(new tuple(row + 1, col));
                }

                if (col > 0 && isWater[row][col - 1] == -1){
                    isWater[row][col-1] = isWater[row][col] + 1;
                    q.offer(new tuple(row, col - 1));
                }

                if (col + 1 < n && isWater[row][col + 1] == -1){
                    isWater[row][col+1] = isWater[row][col] + 1;
                    q.offer(new tuple(row, col + 1));
                }
        }
        return isWater;
    }
}