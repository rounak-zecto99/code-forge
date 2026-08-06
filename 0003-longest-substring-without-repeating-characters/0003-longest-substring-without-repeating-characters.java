class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set <Character> set = new HashSet<>();
        char [] ch = s.toCharArray();
        int left = 0;
        int size = 0;

        for(int right=0; right<ch.length; right++){
            char cur = ch[right];
            while(set.contains(cur)){
                set.remove(ch[left++]);
            }
            set.add(cur);
            size = Math.max(size, right - left +1);
        }
        return size;
    }
}