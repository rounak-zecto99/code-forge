class Pair {
    int distance;
    int node;

    Pair(int d, int node) {
        this.distance = d;
        this.node = node;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] route : flights) {
            int from = route[0];
            int to = route[1];

            int dist = route[2];

            graph.computeIfAbsent(from, z -> new ArrayList<>()).add(new Pair(dist,to));
        }

        int level = 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0,src));

        int [] dist = new int[n];
        Arrays.fill(dist,(int) 1e9);

        dist[src] = 0;

        while(!q.isEmpty() && level <= k){
            int size = q.size();

            for(int i=0; i<size; i++){

                int d = q.peek().distance;
                int node = q.peek().node;

                q.poll();

                // if (d > dist[node]) continue;

                for(Pair p  : graph.getOrDefault(node,Collections.emptyList())){
                    int nNode = p.node;
                    int di = p.distance;

                    if(di + d < dist[nNode]){
                        dist[nNode] = di + d;
                        q.offer(new Pair(dist[nNode], nNode));
                    }
                    // System.out.println(Arrays.toString(dist));
                }
            }
            level++;
        }
        
        return  dist[dst] ==  (int) 1e9 ? -1 : dist[dst];      
    }
}