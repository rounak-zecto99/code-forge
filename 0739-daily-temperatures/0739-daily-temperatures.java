class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int [] ans = new int [temp.length];
        Stack <Integer> stack = new Stack<>();
        for(int i=temp.length-1;i>=0; i--){
         while(!stack.isEmpty() && temp[stack.peek()]<=temp[i]){
            stack.pop();
         }
         ans[i] = stack.isEmpty()?0:stack.peek()-i;
         stack.push(i);
        }
        return ans;
    }
}