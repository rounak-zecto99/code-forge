class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cur = check(nums, i, j);
                ans += cur * cur;
            }
        }
        return ans;
    }

    int check(List<Integer> nums, int start, int end) {
        // boolean[] track = new boolean[101];
        long a = 0L;
        long b = 0L;

        int counter = 0;

        for (int i = start; i <= end; i++) {
            int num = nums.get(i);
            if (num < 62) {
                if(((1L<<num) & a) == 0){
                    counter++;
                }
                a |= 1L << num;
            }
            else{
                num = num - 62;
                if(((1L<<num) & b) == 0){
                    counter++;
                }
                b |= 1L << num;
            }
        }
        return counter;
    }
}