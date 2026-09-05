class Solution {
    public long findMaximumScore(List<Integer> nums) {

        long score = 0;
        int i = 0;

        for (int j = 1; j < nums.size(); j++) {

            if (nums.get(j) > nums.get(i)) {
                score += (long)(j - i) * nums.get(i);
                i = j;
            }
        }

        // final jump to the end
        score += (long)(nums.size() - 1 - i) * nums.get(i);

        return score;
    }
}