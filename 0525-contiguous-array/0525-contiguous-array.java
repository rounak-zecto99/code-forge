class Solution {
    public int findMaxLength(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int presum = 0;
        int maxlength = 0;

        for(int i=0; i<nums.length; i++){
            if((nums[i]&1) == 1){
                presum++;
            }
            else{
                presum--;
            }
            if(map.containsKey(presum)){
                int length = i - map.get(presum);
                maxlength = Math.max(maxlength,length);
            }
            else{
                map.put(presum,i);
            }
        }
        return maxlength;
    }
}