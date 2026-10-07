class Solution {
    public int smallestNumber(int n, int t) {
        int sum = 1;
        int num = n;
        while (num > 0) {
            sum *= num % 10;
            num /= 10;
        }

        if(sum % t != 0){
            return smallestNumber(n+1,t);
        }
        return n;
    }
}