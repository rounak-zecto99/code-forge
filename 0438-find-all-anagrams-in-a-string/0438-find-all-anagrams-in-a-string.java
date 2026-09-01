class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=s.length()-p.length();i++){
            if(isAnagram(s,p,i)){
                list.add(i);
            }
        }
        return list;

    }
        public boolean isAnagram(String s, String t,int index) {
        // if(s.length() != t.length())
        // return false;
    
    int [] alphabets = new int [26];

    for(int i =index; i<index+t.length() ;i++){
        alphabets[s.charAt(i) - 'a']++;
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