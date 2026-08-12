class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), list);

        return list;
    }

    public void helper(int index, int[] nums, List<Integer> row, List<List<Integer>> list) {

        // every path is a valid subset
        list.add(new ArrayList<>(row));

        for (int i = index; i < nums.length; i++) {

            // skip duplicates at the same recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // choose
            row.add(nums[i]);

            // move forward
            helper(i + 1, nums, row, list);

            // undo choice
            row.remove(row.size() - 1);
        }
    }
}