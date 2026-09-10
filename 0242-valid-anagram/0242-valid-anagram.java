class Solution {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] hash = new int[26];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            hash[a[i] - 'a']++;
            hash[b[i] - 'a']--;
        }
        for (int i : hash) {
            if (i != 0)
                return false;
        }
        return true;
    }
}