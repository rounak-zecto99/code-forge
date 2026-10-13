class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int []prefix = new int[1000000 + 2];

        for(int i=0; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            prefix[start]++;
            prefix[end]--;
        }
        int ans = 0;
        int best = 0;

        for(int x : prefix){
            ans += x;
            best = Math.max(best,ans);
        }
        return best;
    }
}