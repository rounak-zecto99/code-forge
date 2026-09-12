class Solution {
    public int[] singleNumber(int[] nums) {
        //(num&num-1)^num
        int res = 0;
        for(int i: nums){
            res^=i;
        }
        int mask = res & -res;
        int bucket1 = 0;
        int bucket2 = 0;

        for(int i: nums){
            if((i&mask) != 0){
                bucket1^=i;
            }
            else{
                bucket2^=i;
            }
        }
        return new int[]{bucket1,bucket2};
    }
}