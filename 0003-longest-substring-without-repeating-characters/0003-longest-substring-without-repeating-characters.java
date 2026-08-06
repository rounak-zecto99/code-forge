class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> map = new HashMap<>();
        char [] ch = s.toCharArray();
        int left = 0;
        int size = 0;

        for(int right=0; right<ch.length; right++){
            char curr = ch[right];
           if(map.containsKey(curr)){
            left = Math.max(left,map.get(curr)+1);
           }
           map.put(curr, right);

           size = Math.max(size, right-left+1);
        }
        return size;
    }
}