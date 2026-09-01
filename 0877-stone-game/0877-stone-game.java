class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        if((n&1) == 0)
        return true;
        int res = helper(piles,0,piles.length - 1);
        
        if(res>0)
            return true;

        return false;

    }
    public int helper(int[]piles , int left , int right){
        if(left == right)
        return piles[left];

        int choice1 = piles[left] - helper(piles,left+1,right);
        int choice2 = piles[right] - helper(piles,left,right-1);

        return Math.max(choice1,choice2);
    }
}