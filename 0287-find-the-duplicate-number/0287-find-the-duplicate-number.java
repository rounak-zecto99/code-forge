class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } 
        while(slow!=fast);

        int finder = 0;

        while(finder!=slow){
            finder = nums[finder];
            slow = nums[slow];
        }

        return finder;
    }
}