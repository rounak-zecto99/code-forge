class Solution {
    public List<Integer> primeRange(int l, int r) {
       boolean [] nums = new boolean [r+1];
       List<Integer> list = new ArrayList<>();
       
       if(l==1)
       l++;
       
       for(int i=2;i*i<=r;i++){
           if(!nums[i]){
           for(int j = i*i; j<=r ; j+=i){
               nums[j] = true;
           }
           }   
       }
    //   System.out.println(Arrays.toString(nums));
       for(int i=l; i<=r ;i++){
           if(!nums[i])
           list.add(i);
       }
       return list;
    }
}