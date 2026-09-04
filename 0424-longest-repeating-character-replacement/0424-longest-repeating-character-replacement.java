class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int maxf = 0;
        int back =0;
        int size=0;

        for(int i=0; i<s.length();i++){
            char a = s.charAt(i);
           freq[a-'A']++;
           maxf = Math.max(maxf,freq[a-'A']);

           while((i-back+1)-maxf > k){
            char b = s.charAt(back++);
            freq[b-'A']--;
           }
           size = Math.max(size,i-back+1);
        }
    return size;

    }
}