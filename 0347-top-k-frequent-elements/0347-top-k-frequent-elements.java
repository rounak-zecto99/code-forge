class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int n : map.keySet()) {
            int val = map.get(n);
            bucket[val].add(n);
        }
        int[] ans = new int[k];
        int j = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            for (int x : bucket[i]) {
                if (j == k)
                    return ans;
                ans[j++] = x;
            }
        }
        return ans;
    }
}