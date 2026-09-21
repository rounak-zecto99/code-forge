class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<>();

        if (s.length() <= 10)
            return list;

        HashSet<String> set = new HashSet<>();
        HashSet<String> added = new HashSet<>();

        set.add(s.substring(0, 10));

        for (int i = 10; i < s.length(); i++) {

            String current = s.substring(i - 9, i + 1);

            if(!set.add(current) && added.add(current)){
                list.add(current);
            }
        }

        return list;
    }
}