class Solution {
    int mod = 1000_000_007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int parity = 0;
        int odd = 0;
        int even = 1;
        int count = 0;

        for(int num : arr){
            parity ^= num &1;

            if(parity == 0){
                count = (count + odd) % mod;
                even++;
            }
            else{
                count = (count + even) % mod;
                odd++;
            }
        }
        return count;
    }
}