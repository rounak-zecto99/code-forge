class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque <Integer> dq = new ArrayDeque<>();
        int [] ans = new int[nums.length - k +1];
        
        for(int i=0; i<nums.length; i++){

             if(!dq.isEmpty() && i - dq.peekFirst()>=k){
                dq.removeFirst();
             }           
             while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
             dq.addLast(i);

                  
                
               if( i>=k-1 ){
                ans[i+1-k] = nums[dq.peekFirst()];
             }
        
        }
        return ans;
    }
}