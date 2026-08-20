class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] last = new int[128];
        Arrays.fill(last,-1);

        char[] ch = s.toCharArray();
        int left = 0;
        int size = 0;
        for(int i=0; i<ch.length; i++){
            char a = ch[i];

            if(last[a] != -1){
                left = Math.max(left,last[a]+1);
            }
            last[a] = i;
            size = Math.max(size,i-left+1);
        }
        return size;
    }
}