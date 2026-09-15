class Solution {
    public int numberOfSubstrings(String s) {
        int lasta = -1;
        int lastb = -1;
        int lastc = -1;

        int boundary = -1;
        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a')
            lasta = i;

            if(s.charAt(i) == 'b')
            lastb = i;

            if(s.charAt(i) == 'c')
            lastc = i;

            boundary = Math.min(lasta,Math.min(lastb,lastc));

            if(boundary>=0){
                count += boundary +1;
            }

        }
        return count;
    }
}