class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int presum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            int rem = presum % k;

            if (rem < 0) {   //handle the negative like -2 mod 5 should be 3 not -2
                rem += k;
            }

            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}