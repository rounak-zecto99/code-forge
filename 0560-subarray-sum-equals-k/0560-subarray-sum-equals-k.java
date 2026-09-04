class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int presum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            int curr = presum - k;

            if(map.containsKey(curr)){
                count+=map.get(curr);
            }
            map.put(presum, map.getOrDefault(presum,0)+1);
        }
        return count;
    }
}