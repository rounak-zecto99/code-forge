class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue <Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num:piles){
            heap.offer(num);
        }
        while(k!=0){
            int x = heap.poll();
            x = (x + 1) / 2;
            heap.offer(x);
            k--;
        }
        int sum =0;
        while(!heap.isEmpty()){
            sum += heap.poll();
        }
        return sum;
    }
}