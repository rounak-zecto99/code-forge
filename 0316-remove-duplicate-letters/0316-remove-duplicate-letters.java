class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        int[] hash = new int[26];
        Arrays.fill(hash, -1);

        boolean[] seen = new boolean[26];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            hash[curr - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i);

            if (seen[curr - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() >= curr && hash[stack.peek() - 'a'] > i) {
                seen[stack.peek() - 'a'] = false;
                stack.pop();
            }

            seen[curr - 'a'] = true;
            stack.push(curr);
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char ch = (char) (stack.removeLast() + 0);
            sb.append(ch);
        }
        
        return sb.toString();
    }

}