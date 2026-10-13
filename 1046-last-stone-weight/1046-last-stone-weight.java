class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : stones){
            heap.offer(x);
        }

       while(heap.size()>1){
           int a =heap.poll();
           int b =heap.poll();
           
           int c = a - b;

           if(c != 0)           
           heap.offer(c);
       }
       return heap.isEmpty() ? 0: heap.peek();
    }
}