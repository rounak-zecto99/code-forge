class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> elem = new LinkedHashMap<>();
        HashMap<Integer,Integer> freq = new LinkedHashMap<>();

        for(int x : nums){
            elem.put(x,elem.getOrDefault(x,0)+1);
        }
        for (int k : elem.values()){
            freq.put(k,freq.getOrDefault(k,0)+1);
        }
        for(int num : freq.keySet()){
            if(freq.get(num) == 1){
                for(int j : elem.keySet()){
                    if(elem.get(j) == num){
                        return j;
                    }
                }
            }
        }
        return -1;
    }
}