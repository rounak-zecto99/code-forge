class Solution {

public void pse(int[] nums, int[] pse) {
    int n = nums.length;
    int[] stack = new int[n];
    int top = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && nums[stack[top]] >= nums[i]) {
            top--;
        }

        pse[i] = (top == -1) ? -1 : stack[top];
        stack[++top] = i;
    }
}

public void nse(int[] nums, int[] nse) {
    int n = nums.length;
    int[] stack = new int[n];
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && nums[stack[top]] > nums[i]) {
            top--;
        }

        nse[i] = (top == -1) ? n : stack[top];
        stack[++top] = i;
    }
}

public void pge(int[] nums, int[] pge) {
    int n = nums.length;
    int[] stack = new int[n];
    int top = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && nums[stack[top]] <= nums[i]) {
            top--;
        }

        pge[i] = (top == -1) ? -1 : stack[top];
        stack[++top] = i;
    }
}

public void nge(int[] nums, int[] nge) {
    int n = nums.length;
    int[] stack = new int[n];
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && nums[stack[top]] < nums[i]) {
            top--;
        }

        nge[i] = (top == -1) ? n : stack[top];
        stack[++top] = i;
    }
}

public long subArrayRanges(int[] nums) {
    int n = nums.length;

    int[] pse = new int[n];
    int[] nse = new int[n];
    int[] pge = new int[n];
    int[] nge = new int[n];

    pse(nums, pse);
    nse(nums, nse);
    pge(nums, pge);
    nge(nums, nge);

    long sumMin = 0;
    long sumMax = 0;

    for (int i = 0; i < n; i++) {
        long countMin = (long) (i - pse[i]) * (nse[i] - i);
        sumMin += countMin * nums[i];

        long countMax = (long) (i - pge[i]) * (nge[i] - i);
        sumMax += countMax * nums[i];
    }

    return sumMax - sumMin;
}

}
