class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {

            if (right - left > k) {
                int last = nums[left++];
                map.remove(last);
            }
            
            if(map.containsKey(nums[right]))
            return true;

            map.put(nums[right], right);

        }
        return false;
    }
}