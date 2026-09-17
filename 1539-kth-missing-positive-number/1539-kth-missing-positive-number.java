class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int end = n-1;
        int start = 0;
        if(k<arr[0])
        return k;
        
        while(start<=end){
            int mid = start+((end-start)>>1);

            if(arr[mid]-mid-1<k){
                start =mid+1;
            }
            else{
                end = mid-1;
            }
        }
        int rem = arr[end]-end-1;
        return arr[end]+(k-rem);
    }
}