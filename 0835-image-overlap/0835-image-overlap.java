class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        HashMap <String,Integer> map = new HashMap<>();
        int n = img1.length;
        int maxShift = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(img1[i][j] == 1){
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++){
                            if(img2[x][y] == 1){
                                int distx = x - i;
                                int disty = y - j;

                                String key = distx +","+ disty;
                                int count = map.getOrDefault(key,0)+1;
                                maxShift = Math.max(maxShift,count);
                                map.put(key,count);
                            }
                        }
                    }
                }
            }
        }
        return maxShift;
    }
}