Minimize Max Distance of Adjacent Gas Stations
class Solution {
    //Given a gap of length L and a maximum allowed distance D, how many stations are needed?"
    public double minMaxDist(int[] stations, int k) {
       double start =0;double end = 0;
        for(int i=1;i<stations.length;i++){
            end = Math.max(end, stations[i]-stations[i-1]);
        }
        
       while (end - start > 1e-6) {
       double mid = start + (end - start) / 2.0;
        double gap =0;
        int placed = 0;
        
        for(int i =1; i<stations.length; i++){
           
                gap =  stations[i] - stations[i-1];
                placed +=(int) Math.ceil(gap/mid) -1 ;
            
        }
        
        if(placed>k){
            start =mid;
        }
        else{
            end = mid;
        }
    
       }
       return end;
    }
}
