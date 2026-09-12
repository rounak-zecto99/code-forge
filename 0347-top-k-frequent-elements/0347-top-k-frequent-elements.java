class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new List[nums.length + 1];

        for (var e : map.entrySet()) {
            int freq = e.getValue();

            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();

            bucket[freq].add(e.getKey());
        }

        int[] ans = new int[k];
        int j = 0;

        for (int freq = nums.length; freq >= 1 && j < k; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    ans[j++] = num;

                    if (j == k)
                        break;
                }
            }
        }

        return ans;
    }
}