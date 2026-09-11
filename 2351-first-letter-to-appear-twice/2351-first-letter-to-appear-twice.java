class Solution {
    public char repeatedCharacter(String s) {
        int [] hash = new int[26];

        for(char a :s.toCharArray()){
            if(hash[a-'a']!=0)
            return a;
            hash[a-'a']++;
        }
        return ' ';
    }
}