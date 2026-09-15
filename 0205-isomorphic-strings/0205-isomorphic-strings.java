class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] hash = new int[128];
        int [] hash2 = new int[128];

       for(int i=0; i<s.length(); i++){
        char a = s.charAt(i);
        char b = t.charAt(i);
        
        if(hash[a]!=hash2[b])
        return false;

        hash[a] = i+1;
        hash2[b] = i+1;
       }
        return true;
    }
}