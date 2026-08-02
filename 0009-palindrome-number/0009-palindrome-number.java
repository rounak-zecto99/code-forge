class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        return x == rev(x);
     
    }
    public int rev(int n ){
        int ans =0;
        while(n>0){
            int e = n%10;
         ans = (ans* 10 )+ e;
         n = n/10;
        }
        return ans;
    }
}