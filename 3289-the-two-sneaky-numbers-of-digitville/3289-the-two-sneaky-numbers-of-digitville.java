class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] hash = new int[101];
        int [] ans = {-1,-1};
        int i = 0;

        for(int a : nums){
            if(hash[a]++ == 1){
                ans[i++] = a;
                if(i == 2) break;
            }
        }
        return ans;
    }
}