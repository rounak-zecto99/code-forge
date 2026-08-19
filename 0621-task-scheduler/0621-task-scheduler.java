class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int [26];
        for(char na : tasks){
            freq[na-'A']++;
        }
        PriorityQueue <Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();

        for(int count: freq){
           if(count>0)
           heap.offer(count);
        }
        int time =0;
    while(!heap.isEmpty() || !q.isEmpty()){

    if(!q.isEmpty() && q.peek()[1] == time){
        heap.offer(q.poll()[0]);
    }

    if(!heap.isEmpty()){
        int remaining = heap.poll() - 1;

        if(remaining > 0){
            q.offer(new int[]{remaining, time + n + 1});
        }
    }

    time++;
}

return time;
}
}