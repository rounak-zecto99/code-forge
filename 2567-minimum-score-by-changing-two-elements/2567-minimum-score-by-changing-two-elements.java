class Solution {
    public int minimizeSum(int[] nums) {

        int[] smallest = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] largest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {

            // Find 3 smallest
            if (num < smallest[0]) {
                smallest[2] = smallest[1];
                smallest[1] = smallest[0];
                smallest[0] = num;
            } 
            else if (num < smallest[1]) {
                smallest[2] = smallest[1];
                smallest[1] = num;
            } 
            else if (num < smallest[2]) {
                smallest[2] = num;
            }

            // Find 3 largest
            if (num > largest[2]) {
                largest[0] = largest[1];
                largest[1] = largest[2];
                largest[2] = num;
            }
            else if (num > largest[1]) {
                largest[0] = largest[1];
                largest[1] = num;
            }
            else if (num > largest[0]) {
                largest[0] = num;
            }
        }

        return Math.min(
            largest[2] - smallest[2],
            Math.min(
                largest[1] - smallest[1],
                largest[0] - smallest[0]
            )
        );
    }
}