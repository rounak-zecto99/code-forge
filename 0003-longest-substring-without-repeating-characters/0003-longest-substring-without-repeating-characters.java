class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character , Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int left = 0;
        int size = 0;
        for(int i=0; i<ch.length; i++){
            char a = ch[i];

            if(map.containsKey(a)){
                left = Math.max(left,map.get(a)+1);
            }
            map.put(a,i);
            size = Math.max(size,i-left+1);
        }
        return size;
    }
}