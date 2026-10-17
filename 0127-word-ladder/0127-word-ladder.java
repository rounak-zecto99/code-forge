class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> graph = new HashSet<>();

        for(String nodes : wordList){
            graph.add(nodes);
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        

        int distance = 1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){

                String cur = q.poll();
                StringBuilder sb = new StringBuilder(cur);

                if(cur.equals(endWord)){
                    return distance;
                }

                for(int j=0 ; j<cur.length(); j++){
                    for(int k=0; k<26; k++){
                        char ch = (char) (k + 'a');
                        String s = cur.substring(0,j) + ch + cur.substring(j+1);

                        if(graph.contains(s) && visited.add(s)){
                            q.offer(s);
                        }
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}