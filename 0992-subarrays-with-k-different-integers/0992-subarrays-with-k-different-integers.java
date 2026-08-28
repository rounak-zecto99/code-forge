class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    public int helper(int[]nums,int k){
        HashMap <Integer,Integer> map = new HashMap<>();
        int count=0;
        int left =0;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.size()>k){
                int a = nums[left++];
                map.put(a,map.get(a)-1);

                if(map.get(a) == 0)
                map.remove(a);
            }
            count+= i-left+1;
        }
        return count;
    }
}