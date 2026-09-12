class Solution {
    public void bitcounter(int[] bits, int num){
        for(int i=0; i<bits.length; i++){
            bits[31-i] += (num>>i)&1;
            bits[31-i] %= 3;
        }
    }
    public int singleNumber(int[] nums) {
        int [] bits = new int[32];

        for(int i :nums){
            bitcounter(bits,i);
        }

        int ans =0 ;
        for(int i=0; i<bits.length; i++){
            ans = ans|(bits[31-i]<<i);
        }
        return ans;
        
    }
}