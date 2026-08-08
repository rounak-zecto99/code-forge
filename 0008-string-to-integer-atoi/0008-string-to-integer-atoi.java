class Solution {
    public int myAtoi(String s) {
        s = s.trim();
       if(s.isEmpty()){
        return 0;
       } 
       int sign=1;
       int start =0;

       if(s.charAt(0) == '+'){
        start++;
       }
       else if(s.charAt(0) == '-'){
        sign = -1;
        start++;
       }
       return helper(s,0,start,sign);
    }
    public int helper(String s,int num, int start, int sign){
        if(start == s.length()){
            return num*sign;
        }
        int digit = s.charAt(start) -'0';

        if(digit>9 || digit <0){
            return num*sign;
        }
       
            if(num > (Integer.MAX_VALUE-digit)/10){
                if(sign == 1){
                return Integer.MAX_VALUE ;
             }
                return Integer.MIN_VALUE;     
         }
        num = num*10 + digit;
        return helper(s,num,start+1,sign);
    }
}