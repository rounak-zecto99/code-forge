class Solution {
    public int binaryToDecimal(String b) {
        int len = b.length()-1;
        int ans = 0;
        
        for(char ch : b.toCharArray()){
            if(ch!='0')
            ans += Math.pow(2,len);
            len--;
        }
        return ans;
    }
}