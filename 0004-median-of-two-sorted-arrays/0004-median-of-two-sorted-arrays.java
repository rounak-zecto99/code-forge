class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        if(b.length < a.length){
            return findMedianSortedArrays(b,a);
        }
        int half = (a.length+b.length+1)/2;
        int s=0; int e= a.length;
            int left1;
            int right1;
            int left2;
            int right2;

        while(s<=e){
            int cutA = s+(e-s)/2;
            int cutB = half - cutA;

            if(cutA == 0){
                left1 =Integer.MIN_VALUE;
            } else{
                left1 = a[cutA-1];
            }
            if(cutA == a.length){
                right1 =Integer.MAX_VALUE;
            } else{
                right1 = a[cutA];
            }

              if(cutB == 0){
                left2 =Integer.MIN_VALUE;
            } else{
                left2 = b[cutB-1];
            }
            if(cutB == b.length){
                right2 =Integer.MAX_VALUE;
            } else{
                right2 = b[cutB];
            }

            if(left1<=right2 && left2<=right1){
             if((a.length+b.length)%2 == 0){
                double ans = Math.max(left1,left2) + Math.min(right1,right2);
                return ans/2.0;
             }
           
                return Math.max(left1,left2);
              
            }
            else if(left1>right2){
                e = cutA-1;
            }
            else {
                s = cutA+1;
            }

        }
        return 0.0;
    }
}