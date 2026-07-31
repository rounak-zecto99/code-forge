class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start =0;
        int end = 0;
        for(int i =0; i< weights.length ;i++){
           start = Math.max(start,weights[i]);
           end += weights[i];
        }
        
        int mid = start+(end-start)/2;
        while(start<end){
            mid = start+(end-start)/2;
            int d = 1;
            int sum =0;
            for (int i=0; i<weights.length; i++){
                if(d>days){
                    break;
                }
                if(sum+weights[i]<=mid){
                   sum += weights[i];
                }
                else{
                    sum = weights[i];
                    d++;
                }
            }
            if(d>days){
                start = mid +1;
            }
            else{
                end = mid;
            }

        }
        return start;
    }
}