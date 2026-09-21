class Solution {
    public int longestSubstring(String s, int k) {
      return solve(s,0,s.length()-1,k);
    }
    public int solve(String s, int left, int right, int k){
        if(right-left+1<k)
        return 0;

        int [] hash = new int[26];

        for(int i=left; i<= right; i++){
            hash[s.charAt(i) - 'a']++;
        }

        for(int i= left; i<=right; i++){
            if(hash[s.charAt(i) - 'a']<k){
                int next = i+1;

                while(next<=right && hash[s.charAt(next) - 'a']<k){
                    next++;
                }
                int left1 = solve(s,left,i-1,k);
                int right2 = solve(s,next,right,k);

                return Math.max(left1,right2);
            }
        }
        return right - left + 1;
    }
}