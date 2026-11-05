class Solution {
    public int maxProfit(int[] prices) {
        int t1cost = Integer.MAX_VALUE;
        int t2cost = Integer.MAX_VALUE;

        int t1Profit = 0;
        int t2Profit = 0;

        for(int price : prices){
            t1cost = Math.min(t1cost,price);
            t1Profit = Math.max(t1Profit, price - t1cost);

            t2cost = Math.min(t2cost,price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2cost);
        }
        return t2Profit;        
    }
}