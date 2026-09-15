class Solution {
    public static int overlapInt(int[][] arr) {
       
       int [] start = new int[arr.length];
       int [] end = new int[arr.length];
       
       for(int i=0; i<arr.length; i++){
           start[i] = arr[i][0];
           end[i] = arr[i][1];
       }
       Arrays.sort(end);
       Arrays.sort(start);
       
       int count =0;
       int max = 0;
       
       int i=0;
       int j =0;
       
       
       while(i<arr.length){
           if(start[i]<=end[j]){
               i++;
               count++;
               max = Math.max(max,count);
           }
           else{
               count--;
               j++;
           }
       }
       return max;
    }
}
       