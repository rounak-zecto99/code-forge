class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start =1;
        int end =position[position.length-1] - position[0];
        int mid ;
        
        while(start < end){
             mid = start+(end-start+1)/2;
             int last = position[0];
             int p =1;
             for(int i=1;i<position.length;i++){
                if(last+mid <= position[i]){
                 last = position[i];
                 p++;
                }
             }
             if(p<m){
                end = mid -1;
             }
             else{
                start = mid;
             }
        }

        return start;

     
    }
}