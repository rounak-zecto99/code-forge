class Solution {
    public int numIdenticalPairs(int[] nums) {
        int [] hash = new int [101];

        for(int n:nums){
            hash[n]++;
        }
        int count = 0;

        for(int i=1;i<hash.length;i++){
            count += hash[i]*(hash[i]-1)/2;
        }
        return count;
    }
}