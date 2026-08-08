class Solution {
    public double myPow(double x, int n) {
     long nn = n;
     if(nn<0){
        nn = -1*nn;
        return 1.0/dick(x,nn);
     }
     return dick(x,nn);
     
    }
    public double dick(double x  , long n ){
           if(n == 0){
            return 1;
        }
      if (n%2==0){
          return dick(x*x,n/2);
      }
      return x * dick(x,n-1);
    }
}

