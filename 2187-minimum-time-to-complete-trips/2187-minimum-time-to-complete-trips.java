class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min = time[0];
        for(int n: time){
            min = Math.min(min,n);
        }
        long start = totalTrips / time.length;
        long end = (long) min * totalTrips;

        while(start<end){
            long mid = start+(end-start)/2;
            long trips = 0;
            for(int i=0; i<time.length ; i++){
                trips += mid/time[i];
                if(trips >= totalTrips){
                   break;
                 }
            }
            if(trips<totalTrips){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}