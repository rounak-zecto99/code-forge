class Solution {
    public String alienOrder(String[] words) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        Set<Integer> isPresent = new HashSet<>();

        int n = words.length;

        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());
        }

        for(String s : words){
            for(char w : s.toCharArray()){
                isPresent.add(w - 'a');
            }
        }

        for(int i=0; i<n-1; i++){
            String first = words[i];
            String second = words[i+1];

            int j = 0;
            int len = Math.min(first.length(),second.length());

            while(j<len && first.charAt(j) == second.charAt(j)){
                j++;
            }

            if(j == len && first.length() > second.length()){
                return "";
            }

            if(j<len){
                int from = first.charAt(j) - 'a';
                int to = second.charAt(j) - 'a';

                graph.get(from).add(to);
            }
        }
         int[] indegree = new int[26];

         for(int node : isPresent){
            for(int neighbour : graph.get(node)){
                indegree[neighbour]++;
            }
         }

         Queue<Integer> q = new ArrayDeque<>();

         for(int node : isPresent){
            if(indegree[node] == 0)
            q.offer(node);
         }

         StringBuilder order = new StringBuilder();

         while(!q.isEmpty()){
            int node = q.poll();
    
            order.append((char)(node + 'a'));

            for(int neighbour : graph.get(node)){
                indegree[neighbour]-- ;

                if(indegree[neighbour] == 0)
                q.offer(neighbour);
            }
         }
         return order.length() == isPresent.size() ? order.toString() : "";
    }
}