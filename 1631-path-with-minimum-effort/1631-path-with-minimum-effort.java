class Solution {
    public static final int inf = Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        int [][] abs = new int[m][n];

        for(int []ar : abs)
        Arrays.fill(ar,inf);

        abs[0][0] = 0;

        PriorityQueue<int[]> cell = new PriorityQueue<>((a, b) ->
                                        Integer.compare(a[2],b[2]));

        cell.offer(new int[]{0,0,0});

        while(!cell.isEmpty()){

            int row = cell.peek()[0];
            int col = cell.peek()[1];

            int effort = cell.peek()[2];

            cell.poll();

            int dist = abs[row][col];

            if(effort > dist)
            continue;

            for(int i=0; i<4; i++){

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow < 0 || ncol < 0 || nrow == m || ncol == n)
                continue;

                int Neffort = Math.max(effort,Math.abs(heights[row][col] - heights[nrow][ncol]));

                if(Neffort < abs[nrow][ncol]){
                    abs[nrow][ncol] = Neffort;
                    cell.offer(new int[]{nrow,ncol,Neffort});
                }
            }
        }
        return abs[m-1][n-1];        
    }
}