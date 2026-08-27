class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0;
        int subarr = 0;

        for(int i = 0; i < nums.length; i++) {
            presum += nums[i];

            int curr = presum - k;

            if(map.containsKey(curr)) {
                subarr += map.get(curr);
            }

            if(map.containsKey(presum)) {
                map.put(presum, map.get(presum) + 1);
            } else {
                map.put(presum, 1);
            }
        }

        return subarr;
    }
}