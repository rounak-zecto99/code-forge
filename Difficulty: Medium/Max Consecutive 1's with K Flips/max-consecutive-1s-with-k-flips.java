class Solution {
    public int maxOnes(int arr[], int k) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        int freq = 0;
        int left = 0;
        int max = 0;
        
        for(int i=0; i < arr.length ; i++){
            if((arr[i]&1) == 1)
            freq++;
            
            while(i-left+1-freq>k){
                if((arr[left++]&1) == 1)
                freq--;
            }
            max = Math.max(max,i-left+1);
        }
        
        return max;
    }
}