class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        return helper(s,0,s.length()-1);
    }
    public boolean helper(String s , int left, int right){
        if(left>=right){
            return true;
        }
        char l = s.charAt(left);
        char r = s.charAt(right);
        
        if (!Character.isLetterOrDigit(l))
            return helper(s, left + 1, right);

        if (!Character.isLetterOrDigit(r))
            return helper(s, left, right - 1);;

        return s.charAt(left) == s.charAt(right) && helper(s,left+1,right-1);
    }
}