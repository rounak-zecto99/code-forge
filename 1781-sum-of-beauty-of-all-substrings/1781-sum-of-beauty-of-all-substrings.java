class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                int maxf = Integer.MIN_VALUE;
                int minf = Integer.MAX_VALUE;

                for (int ha : map.values()) {
                    maxf = Math.max(maxf, ha);
                    minf = Math.min(minf, ha);
                }
                sum += maxf - minf;
            }
        }

        return sum;

    }
}