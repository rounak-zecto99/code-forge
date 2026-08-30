class Solution {
    public void pse(int[] nums, int[] pse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    public void nse(int[] nums, int[] nse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = nums.length;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] pse = new int[n];
        pse(nums,pse);

        int[] nse = new int[n];
        nse(nums,nse);

        int[] pge = new int[n];
        pge(nums,pge);

        int[] nge = new int[n];
        nge(nums,nge);
        
        long sumMin = 0;
        long countmin = 0;

        long sumMax = 0;
        long countmax=0;

        long finalsum =0;

        for(int i=0; i<n; i++){

            countmin = (i - pse[i])*(nse[i] - i);
            sumMin += countmin*nums[i];

            countmax = (i - pge[i])*(nge[i] -i);
            sumMax += countmax*nums[i];

        }
        finalsum = sumMax - sumMin;
        return finalsum;
    }

    public void pge(int[] nums, int[] pge) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }

    }

    public void nge(int[] nums, int[] nge) {
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = nums.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}