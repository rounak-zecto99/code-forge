class Solution {
    public String smallestSubsequence(String s) {

        int n = s.length();

        int[] hash = new int[26];
        Arrays.fill(hash, -1);

        boolean[] seen = new boolean[26];

        // Array implemented stack
        int[] stack = new int[n];
        int top = -1;

        // Last occurrence
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            hash[curr - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {

            int curr = s.charAt(i);

            if (seen[curr - 'a'])
                continue;

            while (top != -1
                    && stack[top] > curr
                    && hash[stack[top] - 'a'] > i) {

                seen[stack[top] - 'a'] = false;
                top--;
            }

            seen[curr - 'a'] = true;
            stack[++top] = curr;
        }

        StringBuilder sb = new StringBuilder();

        // Read stack from bottom to top
        for (int i = 0; i <= top; i++) {
            sb.append((char) stack[i]);
        }

        return sb.toString();
    }
}