class Solution {
    public String largestPalindromic(String num) {
        int[] hash = new int[10];

        for (char a : num.toCharArray()) {
            hash[a - '0']++;
        }

        // First we fill mid
        Deque<Character> mid = new ArrayDeque<>();
        StringBuilder first = new StringBuilder();
        Deque<Character> sec = new ArrayDeque<>();
        boolean zero = true;

        for (int i = 9; i > 0; i--) {
            if (hash[i] > 0) {
                zero = false;
                int freq = hash[i];

                if (freq % 2 != 0) {
                    if (mid.isEmpty()) {
                        mid.addFirst((char) ('0' + i));
                        freq--;
                    }

                    for (int j = 1; j <= freq / 2; j++) {
                        first.append((char) ('0' + i));
                    }

                    for (int j = 1; j <= freq / 2; j++) {
                        sec.addFirst((char) ('0' + i));
                    }
                } else {
                    for (int j = 1; j <= freq / 2; j++) {
                        first.append((char) ('0' + i));
                    }

                    for (int j = 1; j <= freq / 2; j++) {
                        sec.addFirst((char) ('0' + i));
                    }
                }
            }
        }
        if(zero)
        return "0";

        if (hash[0] > 0 && !sec.isEmpty()) {
            int fr = hash[0];

            if(mid.isEmpty()){
                for (int j = 1; j <= fr; j++) {
                mid.addFirst('0');
            }
            
            }
            else{

            for (int j = 1; j <= fr / 2; j++) {
                mid.addFirst('0');
            }

            for (int j = 1; j <= fr / 2; j++) {
                mid.addLast('0');
            }
        }
        }

        while (!mid.isEmpty()) {
            first.append(mid.removeFirst());
        }

        while (!sec.isEmpty()) {
            first.append(sec.removeFirst());
        }

        return first.toString();
    }
}