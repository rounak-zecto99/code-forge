class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10)
        return false;

        int base = 9;
        n = n - 10;

        while(n - base >= 0 ){
            n= n-base;
            base--;
        }
        return base % 2 != 0;
    }
}