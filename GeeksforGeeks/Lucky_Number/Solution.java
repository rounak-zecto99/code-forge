class Solution {
    public static boolean isLucky(int n) {
     return luck(n,2);   
    }
    public static boolean luck(int n , int gap){
     if(n<gap){
         return true;
     }
     if(n%gap == 0){
         return false;
     }
     n = n - (n/gap);
     return luck(n , gap+1);
     
    }
}
