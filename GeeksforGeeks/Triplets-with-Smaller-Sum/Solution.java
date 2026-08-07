class Solution {
    int countTriplets(int target, int arr[]) {
        Arrays.sort(arr);
        int triplets =0;
        
        for(int i=0; i<arr.length-2; i++){
            
            int start = i+1;
            int end = arr.length-1;
            int newt = target - arr[i];
            while(start < end){
                int sum = arr[start]+ arr[end];
                
                if(sum < newt){
                    triplets += end -start ;
                    start++;
                }
                
                else{
                    end--;
                }
                
                
                
            }
            
          }
          return triplets;
        }
        
    }
