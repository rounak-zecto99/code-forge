class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftmax = 0;
        int rightmax = right;

        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= height[leftmax]) {
                    leftmax = left;
                } else {
                    water += height[leftmax] - height[left];
                }
                left++;
            } else {
                if (height[right] >= height[rightmax]) {
                    rightmax = right;
                } else {
                    water += height[rightmax] - height[right];

                }
                right--;
            }
        }
    return water;

    }
}