class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->
        Integer.compare(a[1],b[1]));

        for(var a : map.entrySet()){
            heap.offer(new int[]{a.getKey(),a.getValue()});

            if(heap.size()>k){
                heap.poll();
            }           
        }
        int [] ans = new int[k];
        int j = k-1;
        for(int i=j;i>=0;i--){
            ans[i] = heap.peek()[0];
            heap.poll();
        }
        return ans;
    }
}