class Solution {
    public char findTheDifference(String s, String t) {

        if(t.length() > s.length()){
            return findTheDifference(t,s);
        }
        int a  = s.charAt(0);

        for(int i=0; i<t.length(); i++){
            a = a ^ t.charAt(i);
            a = a ^ s.charAt(i+1);
        }

        return (char) a;
    }
}