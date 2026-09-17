class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for(int nx:arr){
            if(k<nx)
            break;
            k++;
        }
        return k;
    }
}