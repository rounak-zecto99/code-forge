class Solution {
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int s = 1;
        int e = arr[arr.length -1]- arr[0];
        int end = arr[arr.length -1];
        int ans =0;
        
        while(s<=e){
            
            int len = s+(e-s)/2;
            
            int LastPlaced = arr[0];
            int nums = 1;
            
            for(int i =1; i<arr.length; i++){
                if(arr[i]>=LastPlaced+len){
                    LastPlaced = arr[i];
                    nums++;
                }
            }
            
            if(nums<k){
                e = len -1;
            }
            else{
                ans = len;
                s = len+1;
            }
            
            
        }
        return ans;
    }
}
