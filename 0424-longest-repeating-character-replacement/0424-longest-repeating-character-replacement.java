class Solution {
    public int characterReplacement(String s, int k) {
        HashMap <Character, Integer> map = new HashMap<>();
        int maxf = 0;
        int left =0; 
        int ans =0;
        for(int i=0;i<s.length();i++){

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1);
            maxf = Math.max(maxf,map.get(s.charAt(i)));
            
            while((i-left+1) - maxf >k){
                char curr = s.charAt(left++);
                map.put(curr,map.get(curr)-1);

            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}