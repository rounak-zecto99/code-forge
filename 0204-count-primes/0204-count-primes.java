class Solution {
    public int countPrimes(int n) {
        int primes = 0;
        boolean [] p = new boolean[n];

        for(long i=2; i<n; i++){
            if(!p[(int)i]){
                primes++;
                for(long j=i*i; j<n; j+=i){
                    p[(int)j] = true;
                }
            }
        }
        return primes;
    }
}