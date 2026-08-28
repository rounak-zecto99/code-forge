class Solution {
    public int numberOfSubstrings(String s) {
        int lasta = -1;
        int lastb = -1;
        int lastc = -1;

        int left=0;
        int count=0;

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == 'a')
            lasta = i;

            if(ch == 'b')
            lastb = i;

            if(ch == 'c')
            lastc = i;

            int boundary = Math.min(lasta,Math.min(lastb,lastc));

            if(boundary>=left){
                count += boundary - left+1;
            }

        }
        return count;
    }
}