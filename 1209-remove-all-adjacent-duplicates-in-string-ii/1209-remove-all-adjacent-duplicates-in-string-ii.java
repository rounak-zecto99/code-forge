class Solution {
    public String removeDuplicates(String s, int k) {
        Stack <int[]> stack = new Stack<>();
        boolean dup = false;

        for(int i=0; i<s.length(); i++){
           
            if(stack.isEmpty()){
                stack.push(new int[]{s.charAt(i),1});
            }
            else{
                if(stack.peek()[0] == s.charAt(i)){
                    stack.push(new int[]{s.charAt(i),stack.peek()[1]+1});
                    if(stack.peek()[1] == k){
                        dup = true;
                        for(int j=k;j>0;j--){
                            stack.pop();
                        }
                    }
                }
                else{
                    stack.push(new int[]{s.charAt(i),1});
                }
            }
        }
        if(!dup)
        return s;

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            char curr =(char) stack.peek()[0];
            sb.append(curr);
        //    System.out.println(curr);
           stack.pop();
        }
        // return s;
        return sb.reverse().toString();
    }
}