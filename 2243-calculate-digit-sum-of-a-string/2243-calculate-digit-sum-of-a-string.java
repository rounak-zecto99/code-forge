class Solution {
    public String digitSum(String s, int k) {

        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {
            int cur = 0;

            for (int j = 0; j < k; j++) {
                if (i + j >= s.length()) {

                    sb.append(Integer.toString(cur));

                    return digitSum(sb.toString(), k);
                }
                cur += (s.charAt(i + j) - '0');
            }
            sb.append(Integer.toString(cur));
        }
        return digitSum(sb.toString(), k);

    }
}