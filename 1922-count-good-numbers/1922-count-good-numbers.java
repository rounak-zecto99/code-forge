class Solution {
    static long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even =0;
        long odd =0;
          if((n & 1) == 0){
            even = n/2;
            odd = n/2;
          }
          else{
          even = n/2 +1;
          odd = n/2;
          }
         return (int) ((pow(5,even) * pow(4,odd))%MOD);
    }
    public long pow(long n , long x){
       
        if(x == 0){
            return 1;
        }
        if(x%2 == 0){
            return pow((n*n)% MOD,x/2);
        }
        return (n*pow(n,x-1))%MOD;
    }
  
}