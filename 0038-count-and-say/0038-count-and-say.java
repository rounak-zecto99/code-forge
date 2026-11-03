class Solution {
    String ans = "1";

    public String countAndSay(int n) {
        if(n == 1)
        return ans;

        Stack<int[]> stack = new Stack<>();

        for(char ch: ans.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0] == ch){
                stack.peek()[1]++;
            }
            else{
                stack.push(new int[]{ch,1});
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int [] a : stack){
            sb.append(a[1]);
            sb.append((char)a[0]);
        }
        ans = sb.toString();

        return countAndSay(n-1);
    }
}