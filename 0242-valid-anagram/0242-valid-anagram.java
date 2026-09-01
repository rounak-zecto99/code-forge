class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        return false;
    
    int [] alphabets = new int [26];

    for(int i : s.toCharArray()){
        alphabets[i - 'a']++;
    }
    for(int e : t.toCharArray()){
        alphabets[e - 'a']--;
    }
    for(int j : alphabets){
        if(j!=0)
        return false;
    }

    return true;


    }
}