class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        helper(list, new ArrayList<>(), nums, seen);

        return list;
    }

    public void helper(List<List<Integer>> list, List<Integer> row, int[] nums, boolean[] seen) {
        if (row.size() == nums.length) {
            list.add(new ArrayList<>(row));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (seen[i])
                continue;

            seen[i] = true;
            row.add(nums[i]);
            helper(list, row, nums, seen);
            row.remove(row.size() - 1);
            seen[i] = false;

        }
    }
}