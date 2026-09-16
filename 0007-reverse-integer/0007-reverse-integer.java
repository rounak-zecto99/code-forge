class Solution {
    public int reverse(int x) {
        // System.out.println(Integer.MIN_VALUE);
        int sign =1;
        int ans;

        if(x>0){
            ans = helper(x,sign);
        }
        else{
            sign = -1;
            x = -1*x;
            ans = helper(x,sign);
        }
        return ans;
    }
    public int helper(int x,int sign){
        int a = 0;
        int copy = x;

        while(copy>0){
            
            if(a>(Integer.MAX_VALUE-copy%10)/10){
                return 0;
            }
            a = a*10 + copy%10;
            copy = copy/10;
        }
        return a*sign;        
    }
}