class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {

            while (right - left > k) {
                int last = nums[left++];
                map.remove(last);
            }
            int count = map.getOrDefault(nums[right], 0) + 1;
            if (count > 1)
                return true;

            map.put(nums[right], count);

        }
        return false;
    }
}