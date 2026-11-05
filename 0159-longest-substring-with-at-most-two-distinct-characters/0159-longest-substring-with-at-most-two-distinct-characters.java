class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length() < 2)
        return s.length();

        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {

            char cur = s.charAt(right);
            map.put(cur, right);

            if (map.size() > 2) {

                int minIndex = Integer.MAX_VALUE;
                char remove = ' ';

                for (char key : map.keySet()) {
                    if (map.get(key) < minIndex) {
                        minIndex = map.get(key);
                        remove = key;
                    }
                }

                left = minIndex + 1;
                map.remove(remove);
            }

                best = Math.max(best, right - left + 1);
        }
        return best;
    }
}