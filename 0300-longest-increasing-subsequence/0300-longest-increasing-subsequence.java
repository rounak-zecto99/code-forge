class Solution {
    void swap(ArrayList<Integer> list, int a, int b){
        int temp = list.get(b);
        list.set(b,list.get(a));
        list.set(a,temp);
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i =1; i<nums.length; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }
            else{
                int start = 0;
                int end = list.size() -1;

                while(start <= end){
                    int mid = start + ((end - start)>>1);

                    if(list.get(mid) == nums[i]){
                        start = mid;
                        break;
                    }
                    else if(list.get(mid) < nums[i]){
                        start = mid + 1;
                    }
                    else{
                        end = mid -1;
                    }
                }
                list.set(start,nums[i]);
            }
        }
        return list.size();
    }
}