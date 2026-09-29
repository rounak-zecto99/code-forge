class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        int i = 0;

        while (i < s.length && j < g.length){
            if(g[j] <= s[i]){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j;
        
    }
}