class Solution {
    public long subarrayXor(int arr[], int k) {
        
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    
    long count = 0;
    int prefix = 0;
    
    for(int i=0; i<arr.length; i++){
        prefix^=arr[i];
        
        int req = prefix^k;
        
        if(map.containsKey(req)){
            count += map.get(req);
        }
        
        map.put(prefix,map.getOrDefault(prefix,0)+1);
    }
    return count;
    }
}