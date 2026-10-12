class Solution {
    public String decodeString(String s) {
        Deque <StringBuilder> strstack = new ArrayDeque<>();
        Deque <Integer> numstack = new ArrayDeque<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }
            else if(ch == '['){
                strstack.push(sb);
                numstack.push(num);

                num = 0;
                sb = new StringBuilder();
            }
            else if(ch == ']'){
                int repeat = numstack.pop();
                StringBuilder prev = strstack.pop();

                for(int j=0; j<repeat; j++){
                    prev.append(sb);
                }
                sb = prev;
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}