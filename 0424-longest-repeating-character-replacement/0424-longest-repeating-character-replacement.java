class Solution {
    public int characterReplacement(String s, int k) {
        int [] hash = new int [26];
        int maxf = 0;
        int back =0;
        int ans =0;

        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i) - 'A']++;
            maxf = Math.max(maxf,hash[s.charAt(i) - 'A']);

            while((i-back+1)-maxf > k){
                char curr = s.charAt(back++);
                hash[curr - 'A']--;
            }
            ans = Math.max(ans,(i-back+1));
        
        }
        return ans;
    }
}