class Solution {
    public int firstUniqueFreq(int[] nums) {
        int[] elementFreq = new int[100001];
        int[] freqCount = new int[nums.length + 1];

        for (int num : nums) {
            elementFreq[num]++;
        }

        for (int frequency : elementFreq) {
            if (frequency > 0) {
                freqCount[frequency]++;
            }
        }

        for (int num : nums) {
            if (freqCount[elementFreq[num]] == 1) {
                return num;
            }
        }

        return -1;
    }
}