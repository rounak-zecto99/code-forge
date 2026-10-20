class Solution {
    public int findNthDigit(int n) {
        
        long len = 1;
        long start = 1;
        long count = 9;

        while(n > count*len){
            n -= count*len;
            count *= 10;
            start *= 10;
            len++;
        }

        long number = start + (n - 1)/len;
        int index = (int) ((n - 1) % len);

        return String.valueOf(number).charAt(index) - '0';

    }
}