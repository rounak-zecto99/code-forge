class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] arr = new int [n<<1];
        int a =0;
        int b =n;

        for(int i=0; i<arr.length; i++){
            if((i&1) == 0){
                arr[i] = nums[a++];
            }
            else{
                arr[i] = nums[b++];
            }
        }
        return arr;
    }
}