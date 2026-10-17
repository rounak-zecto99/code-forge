class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        words.remove(beginWord);

        int distance = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(endWord)) {
                    return distance;
                }

                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;

                        chars[j] = ch;
                        String s = new String(chars);

                        if (words.remove(s)) {
                            q.offer(s);
                        }
                    }

                    chars[j] = original;
                }
            }

            distance++;
        }

        return 0;
    }
}