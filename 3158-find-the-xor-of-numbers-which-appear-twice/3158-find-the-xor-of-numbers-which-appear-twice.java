class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] freq = new int[51];
        int ans = 0;

        for (int x : nums) {
            freq[x]++;
            
            if (freq[x] == 2) {
                ans ^= x;
            }
        }
        // System.out.println(Arrays.toString(hash));
        return ans;
    }
}