class Solution {
    public static boolean isAnagram(String s, String t) {

       if(s.length() != t.length())
           return false;

        int [] hash = new int[26];

        for(int a:s.toCharArray()){
            hash[a-'a']++;
        }
        for(int a :t.toCharArray()){
            hash[a-'a']--;
        }
        for (int i :hash) {
            if(i!=0)
                return false;
        }
        return true;
    //    System.out.println(Arrays.toString(hash));
    }
}