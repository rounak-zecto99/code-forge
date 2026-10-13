class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        int [] start = new int[n];
        int [] end = new int[n];

        for(int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int max = 0;
        int ans = 0;
        int j = 0;
        int i =0;

        while(i<n){
            if(start[i] < end[j]){
                ans++;
                max = Math.max(max,ans);
                i++;
            }
            else{
                --ans;
                ++j;                
            }
        }
        return max;
    }
}