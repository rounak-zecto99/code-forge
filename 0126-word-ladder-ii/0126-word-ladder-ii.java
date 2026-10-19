class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);

        List<List<String>> ladder = new ArrayList<>();

        if (!dict.contains(endWord))
            return ladder;

        Set<String> level = new HashSet<>();
        boolean found = false;

        level.add(beginWord);

        while (!level.isEmpty() && !found) {

            dict.removeAll(level);
            Set<String> nxtlevel = new HashSet<>();

            for (String word : level) {
                char[] ar = word.toCharArray();

                for (int i = 0; i < ar.length; i++) {
                    char orig = ar[i];
                    for (char cur = 'a'; cur <= 'z'; cur++) {
                        ar[i] = cur;
                        String path = new String(ar);

                        if (dict.contains(path)) {

                            nxtlevel.add(path);
                            graph.computeIfAbsent(path, k -> new ArrayList<>()).add(word);
                        }
                        if (path.equals(endWord)) {
                            found = true;
                        }
                    }
                    ar[i] = orig;
                }
            }
            level = nxtlevel;
        }

        if (found) {
            backtracking(graph, ladder, endWord, beginWord, new ArrayDeque<>());
        }
        return ladder;
    }

    void backtracking(Map<String, List<String>> graph, List<List<String>> ladder,
            String word, String beginWord, Deque<String> path) {

        path.addFirst(word);

        if (word.equals(beginWord)) {
            ladder.add(new ArrayList<>(path));
            path.removeFirst();
            return;
        }

        for (String s : graph.get(word)) {
            backtracking(graph, ladder, s, beginWord, path);
        }
        path.removeFirst();
    }
}