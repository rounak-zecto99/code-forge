class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        int majority1 = nums[0];
        int majority2 = nums[1];

        int count1 = 0;
        int count2 = 0;

        for (int x : nums) {
            if (x == majority1) {
                count1++;
            } else if (x == majority2) {
                count2++;
            } else if (count1 == 0) {
                majority1 = x;
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = x;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // System.out.println(majority1);
        // System.out.println(majority2);
        int freqa = 0;
        int freqb = 0;

        for (int x : nums) {
            if (majority1 == x) {
                freqa++;
            } else if (majority2 == x) {
                freqb++;
            }
        }
        if (freqa > nums.length / 3)
            list.add(majority1);

        if (freqb > nums.length / 3)
            list.add(majority2);

        return list;
    }
}