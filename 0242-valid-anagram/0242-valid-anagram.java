class Solution {
    public static boolean isAnagram(String s, String t) {

       if(s.length() != t.length())
           return false;

        int [] hash = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hash[ch-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            hash[ch-'a']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0)
                return false;
        }
        return true;
    //    System.out.println(Arrays.toString(hash));
    }
}