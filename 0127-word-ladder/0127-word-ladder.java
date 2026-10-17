class Solution {
    public int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        Set<String> dict = new HashSet<>(wordList);

        // The transformation is impossible if endWord is unavailable.
        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();

        front.add(beginWord);
        back.add(endWord);

        dict.remove(beginWord);
        dict.remove(endWord);

        int length = 1;

        while (!front.isEmpty() && !back.isEmpty()) {

            // Always expand the smaller frontier.
            if (front.size() > back.size()) {
                Set<String> temp = front;
                front = back;
                back = temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : front) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;
                        String candidate = new String(chars);

                        // The two searches have met.
                        if (back.contains(candidate)) {
                            return length + 1;
                        }

                        // Discover each dictionary word only once.
                        if (dict.remove(candidate)) {
                            next.add(candidate);
                        }
                    }

                    chars[i] = original;
                }
            }

            front = next;
            length++;
        }

        return 0;
    }
}