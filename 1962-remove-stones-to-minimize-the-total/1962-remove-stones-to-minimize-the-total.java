class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue <Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
                int sum =0;
        for(int num:piles){
            heap.offer(num);
             sum += num;
        }

        while(k!=0){
            int x = heap.poll();
            int newv = (x + 1) / 2;
            heap.offer(newv);
            sum-=x-newv;
            k--;
        }
   
        return sum;
    }
}