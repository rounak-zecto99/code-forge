class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        for(int x:nums){
            smallest = Math.min(smallest,x);
            biggest = Math.max(biggest,x);
        }

        while(smallest!=0){
            int temp = biggest%smallest;
            biggest = smallest;
            smallest = temp;
        }
        return biggest;
    }
}