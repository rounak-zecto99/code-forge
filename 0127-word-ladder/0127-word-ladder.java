class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return 0;

        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();

        front.add(beginWord);
        back.add(endWord);

        dict.remove(beginWord);
        dict.remove(endWord);

        int length = 1;

        while (!front.isEmpty() && !back.isEmpty()) {

            if (front.size() > back.size()) {
                Set<String> temp = front;
                front = back;
                back = temp;
            }
            Set<String> next = new HashSet<>();

            for (String word : front) {
                char[] ar = word.toCharArray();

                for (int i = 0; i < ar.length; i++) {
                    char original = ar[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }
                        ar[i] = ch;
                        String candi = new String(ar);

                        if (back.contains(candi)) {
                            return length + 1;
                        }

                        if (dict.remove(candi)) {
                            next.add(candi);
                        }
                    }
                    ar[i] = original;
                }
            }
            front = next;
            length++;
        }
        return 0;
    }
}