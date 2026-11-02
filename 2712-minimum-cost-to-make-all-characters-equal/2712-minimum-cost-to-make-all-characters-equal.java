class Solution {
    public long minimumCost(String s) {
        long cost = 0L;
        int len = s.length();

        for(int i=1 ; i<len; i++){
            int expected = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';

            if(cur != expected){
                cost += Math.min(i,len-i);
                // System.out.println(cost);
            }
        }
        return cost;
    }
}