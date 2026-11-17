class Solution {
    public String digitSum(String s, int k) {

        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {
            long cur = 0L;

            for (int j = 0; j < k; j++) {
                if (i + j >= s.length()) {

                    sb.append(Long.toString(cur));

                    return digitSum(sb.toString(), k);
                }
                cur += (s.charAt(i + j) - '0');
            }
            sb.append(Long.toString(cur));
        }
        return digitSum(sb.toString(), k);

    }
}