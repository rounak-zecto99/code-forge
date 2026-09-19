class Solution {
    public double myPow(double x, int n) {
       long nn = n;
       
        if(nn<0){
            nn = -1*nn;
            return 1.0/helper(x,nn);
        }
        return helper(x,nn);
    }
    public double helper(double x , long n){

         if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            return helper(x*x,n/2);
        }
        return x*helper(x,n-1);
    }
}