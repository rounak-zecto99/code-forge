class Solution {
    public int reverse(int x) {
        // System.out.println(Integer.MIN_VALUE);
        int sign =1;
        int ans;

        if(x>0){
            ans = helper(x);
        }
        else{
            sign = -1;
            x = -1*x;
            ans = helper(x);
        }
        return ans*sign;
    }
    public int helper(int x){
        long a = 0;
        int copy = x;

        while(copy>0){
            a = a*10 + copy%10;
            if(-1*a<Integer.MIN_VALUE || a>Integer.MAX_VALUE){
                return 0;
            }
            copy = copy/10;
        }
        return (int)a;        
    }
}