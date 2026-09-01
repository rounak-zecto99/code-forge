class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0] == ch){
                stack.peek()[1]++;
            }else{
                stack.push(new int[]{ch,1});
            }
            if(stack.peek()[1] == k){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int []ar : stack){
            for(int i=0; i<ar[1]; i++){
               sb.append((char)ar[0]);
            }
        }
        
        return sb.toString();

    }
}