class Solution {
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        // System.out.println(Integer.toBinaryString(res));
        int counter= 0;
        while(res>0){
            counter+=res&1;
            res>>=1;
        }
        return counter;
    }
}