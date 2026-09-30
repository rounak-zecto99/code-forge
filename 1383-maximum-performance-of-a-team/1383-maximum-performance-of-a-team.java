class Solution {
    int MOD = 1000_000_007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int [][] eng = new int [n][2];

        for(int i=0; i<n; i++){
            eng[i][0] = efficiency[i];
            eng[i][1] = speed[i];
        }
        Arrays.sort(eng,(a,b) -> Integer.compare(b[0],a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long max = 0, speedsum=0;

        for(int j=0; j<n; j++){
            speedsum = speedsum + eng[j][1];

            if(heap.size() == k){
                int minspeed = heap.poll();
                speedsum -= minspeed;
            }
            heap.offer(eng[j][1]);

            long perf = speedsum*eng[j][0];
            max = Math.max(max,perf);
        }
        return(int) (max%MOD);
    }
}