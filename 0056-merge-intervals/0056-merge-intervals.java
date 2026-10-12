class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by increasing time;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        int[][] merged = new int[intervals.length][2];
        merged[0] = intervals[0];
        int size = 0;

        for(int i=1; i<intervals.length; i++){
            if(merged[size][1] >= intervals[i][0]){
                merged[size][1] = Math.max(merged[size][1], intervals[i][1]);
            }
            else{
                merged[++size] = intervals[i];
            }
        }
        return Arrays.copyOf(merged,++size);
    }
}