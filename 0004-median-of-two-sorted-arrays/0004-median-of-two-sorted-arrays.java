class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length)
        return findMedianSortedArrays(nums2,nums1);
        int start = 0;
        int end = nums1.length;
        int left1;
        int left2;
        int right1;
        int right2;
        int half = (nums1.length + nums2.length+1)/2;

        while(start<=end){
            int cutA = start+(end-start)/2;
            int cutB = half - cutA;

            if(cutA == 0){
            left1 = Integer.MIN_VALUE;
            }
            else{
                left1 = nums1[cutA-1];
            }
            if(cutA == nums1.length){
                right1 = Integer.MAX_VALUE;
            }
            else{
                right1 = nums1[cutA];
            }

           if(cutB == 0){
            left2 = Integer.MIN_VALUE;
            }
            else{
                left2 = nums2[cutB-1];
            }
            if(cutB == nums2.length){
                right2 = Integer.MAX_VALUE;
            }
            else{
                right2 = nums2[cutB];
            }

            if(left1<=right2 && left2<=right1){
              if((nums1.length + nums2.length) %2 == 0){
              double ans =Math.max(left1,left2) + Math.min(right1,right2);
              return ans/2.0;
              }
              return(double) Math.max(left1,left2);
            }
            if(left1>right2){
                end = cutA-1;
            }
            else{
                start = cutA+1;
            }
        }
        return 0.0;
    }
}