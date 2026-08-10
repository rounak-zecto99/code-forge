class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque <Integer> dq = new ArrayDeque<>();
        int [] ans = new int[nums.length - k +1];
        int j =0;
        for(int i=0; i<nums.length; i++){

             if(!dq.isEmpty() && i - dq.peekFirst()>=k){
                dq.removeFirst();
             }           
             while(!dq.isEmpty() && (nums[dq.peekLast()] < nums[i] && (i - dq.peekLast())<k)){
                dq.removeLast();
            }
             dq.addLast(i);

                  //window is ready to produce answers
                
               if(!dq.isEmpty() && i>=k-1 ){
                ans[i+1-k] = nums[dq.peekFirst()];
             }
        
        }
        return ans;
    }
}