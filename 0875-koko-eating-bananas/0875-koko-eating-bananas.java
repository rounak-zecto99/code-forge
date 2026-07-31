class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       
        int start = 1; int end = piles[0];
        for(int i=0 ; i<piles.length ;i++){
          if(piles[i]>end){
            end = piles[i];
          }
        }
        int times;
        int ans = 0;
        int mid = start+(end-start)/2;

        while(start<=end){
        mid = start+(end-start)/2;
           times =0;
        for(int i =0; i<piles.length; i++){
            if(times>h){
                break;
            }
            int pile = piles[i];
            if(pile %mid == 0){
                times += pile/mid;
            }
            else{
                times += 1+(pile/mid);
            }
       
        }
        if(times>h){
            start = mid +1;
        }
        else{
            ans = mid;
            end = mid-1;
        }
        }
      
     return ans;
    }
}