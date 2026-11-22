class Solution {
    public boolean checkString(String s) {
        boolean flag = true;

        for(char ch : s.toCharArray()){
            if(ch == 'a' && !flag){
                return false;
            }
            else if(ch ==  'b'){
                flag = false;
            }
        }
        return true;
    }
}