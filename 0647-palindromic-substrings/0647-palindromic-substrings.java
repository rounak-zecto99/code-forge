class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++){
            count += helper(s,i,i);
            count += helper(s,i,i+1);
        }
        return count;
    }
    public int helper(String s , int left, int right){
        int counter = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            counter++;
            left--;
            right++;
        }
        return counter;
    }
}