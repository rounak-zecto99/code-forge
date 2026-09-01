class Solution {
    public List<String> removeAnagrams(String[] words) {
        List <String> list = new ArrayList<>();
        int left =0;
        list.add(words[left]);

        for (int i = 1; i <words.length; i++){
            if(!isAnagram(words[left],words[i])){
                left = i;
                list.add(words[left]);
            }
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] alphabets = new int[26];

        for (int i : s.toCharArray()) {
            alphabets[i - 'a']++;
        }
        for (int e : t.toCharArray()) {
            alphabets[e - 'a']--;
        }
        for (int j : alphabets) {
            if (j != 0)
                return false;
        }

        return true;
    }
}