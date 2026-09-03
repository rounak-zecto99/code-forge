class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxarea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
          while(!stack.isEmpty() && heights[stack.peek()]>currHeight){
            int a = stack.pop();
            int backlimit = stack.isEmpty()?-1:stack.peek();
            int area = heights[a]*(i-backlimit-1);
            maxarea = Math.max(maxarea,area);
          }
          stack.push(i);
        }
        return maxarea;
    }
}