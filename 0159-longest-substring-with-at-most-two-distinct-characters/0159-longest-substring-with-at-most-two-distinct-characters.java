class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // if(s.length() < 2)
        // return 1;

        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {

            char cur = s.charAt(right);

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.size() > 2) {
                char back = s.charAt(left++);

                map.put(back, map.get(back) - 1);

                if (map.get(back) == 0) {
                    map.remove(back);
                }
            }

                best = Math.max(best, right - left + 1);
        }
        return best;
    }
}