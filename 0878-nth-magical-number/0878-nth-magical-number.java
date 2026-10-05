class Solution {
    long mod = 1000_000_007L;
    public int nthMagicalNumber(int n, int a, int b) {
        long start = 1;
        long end = (long) n * Math.min(a, b);

        long lcm = (long) a / gcd(a, b) * b;

        while(start<end){
            long mid = start+ ((end-start)>>1);

            long count = mid / a + mid/b - mid/lcm;

            if(count < n){
                start = mid +1;
            }
            else{
                end = mid;
            }
        }
        return (int)(end%mod);
    }
    long gcd (long a , long b){
        while(b!=0){
            long temp = a %b;
            a = b;
            b = temp;
        }
        return a;
    }
}