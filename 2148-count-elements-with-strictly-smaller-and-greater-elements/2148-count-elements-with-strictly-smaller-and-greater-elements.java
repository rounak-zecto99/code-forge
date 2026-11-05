class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);

        int c = 0;
        int n = nums.length;

        int s = 1;
        int e = n-2;

        while(s < n && nums[s] == nums[s-1]){
            s++;
        }

        while(e > 0 && nums[e] == nums[e+1]){
            e--;
        }

        System.out.println(s);
        System.out.println(e);

        return Math.max(0,e-s+1);
    }
}