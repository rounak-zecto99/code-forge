class Solution {
    public boolean canPlaceFlowers(int[] bed, int n) {
        int curr = 0;
        // int nxt =1;

        while(curr<bed.length){

            if(bed[curr] == 1){
                curr+=2;
            }
            else if(curr+1<bed.length && bed[curr+1] == 1){
                curr+=3;
            }
            else{
                n--;
                curr+=2;
            }
        }
        return n <=0;
    }
}