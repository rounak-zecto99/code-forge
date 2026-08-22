class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans =-1;
        int s=nums1.length;
        int t=nums2.length;
        int i=0;
        int j=0;

        while(i<s && j<t){
            if(nums1[i]>nums2[j]){
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                ans = nums1[i];
                break;
            }
        }
        return ans;
    }
}