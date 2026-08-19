class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int right=0;
        int satisfied=0;

       for(int left=0; left<s.length; left++){
            if(right == g.length)
            break;

            if(g[right] <= s[left]){
            satisfied++;
            right++;
        }

    }
         return satisfied;
    }
}