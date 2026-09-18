class Solution {
    public static int gcd(int a, int b) {
        // code here
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
