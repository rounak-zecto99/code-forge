class Solution {
    public int maxDepth(String s) {
        char [] ch = s.toCharArray();
        int depth = 0;
        int max= 0;

        for(char i: ch){
            if(i == '('){
                depth++;
                max = Math.max(max,depth);
            }
            else if(i == ')'){
                depth--;
            }
        }
        return max;
    }
}