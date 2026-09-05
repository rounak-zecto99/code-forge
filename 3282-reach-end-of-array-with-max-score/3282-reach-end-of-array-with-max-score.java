class Solution {
    public long findMaximumScore(List<Integer> nums) {

        int n = nums.size();

        // Pass 1: Find Next Greater Element
        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && nums.get(stack.peek()) <= nums.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }

            stack.push(i);
        }

        // Pass 2: Follow the NGE jumps and calculate score
        long score = 0;
        int i = 0;

        while (i < n - 1) {

            int next = nge[i];

            // No greater element → jump directly to end
            if (next == -1) {
                next = n - 1;
            }

            score += (long) (next - i) * nums.get(i);

            i = next;
        }

        return score;
    }
}