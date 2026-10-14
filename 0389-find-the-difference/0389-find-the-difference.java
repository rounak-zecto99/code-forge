class Solution {
    public char findTheDifference(String s, String t) {

        if(t.length() > s.length()){
            return findTheDifference(t,s);
        }
        int extra  = s.charAt(0);

        for(int i=0; i<t.length(); i++){
            extra = extra ^ t.charAt(i);
            extra = extra ^ s.charAt(i+1);
        }

        return (char) extra;
    }
}