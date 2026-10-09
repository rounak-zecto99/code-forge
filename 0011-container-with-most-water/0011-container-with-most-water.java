class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int water = 0;

        while(left < right){
            if(height[left]<height[right]){
                water = Math.max(water, height[left]*(right-left));
                left++;
            }
            else{
                water = Math.max(water, height[right]*(right-left));
                right--;
            }
        }
        return water;
    }
}