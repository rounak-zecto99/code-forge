class Solution {
    public int countFlips(int[] arr) {
        int count = 0;
        int expected = 1;
        
        for(int a : arr){
            if(a!=expected){
                expected = 1 ^ expected;
                count++;
            }
        }
        return count;
        
    }
}