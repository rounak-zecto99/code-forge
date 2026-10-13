class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> elementFreq = new LinkedHashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int num : nums) {
            elementFreq.put(num, elementFreq.getOrDefault(num, 0) + 1);
        }

        for (int frequency : elementFreq.values()) {
            freqCount.put(frequency, freqCount.getOrDefault(frequency, 0) + 1);
        }

        for (int num : elementFreq.keySet()) {
            int frequency = elementFreq.get(num);

            if (freqCount.get(frequency) == 1) {
                return num;
            }
        }

        return -1;
    }
}