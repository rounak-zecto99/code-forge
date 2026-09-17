class Solution {
    public int primeSum(int n) {
        
       boolean [] primes = new boolean[n+1];
       int sum = 0;
       
       for(int i=2; i<=n; i++){
           if(!primes[i]){
               for(long j=(long)i*i; j<=n; j+=i){
                   primes[(int)j] = true;
               }
            sum += i;
           }
       }
       return sum;
    }
}