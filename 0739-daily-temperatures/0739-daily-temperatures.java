class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int [] ans = new int [temp.length];
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<temp.length; i++){

          while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
            ans[stack.peek()] = i - stack.pop();
          }
          stack.push(i);
        }
        return ans;
    }
}