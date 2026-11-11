class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == rev(x);
    }

    public int rev(int x) {
        int a = 0;

        while (x != 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        return a;
    }
}