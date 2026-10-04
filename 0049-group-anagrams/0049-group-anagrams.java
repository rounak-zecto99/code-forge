class Solution {
    boolean isAna(String s , String t){
        if(s.length() != t.length())
        return false;

        int [] hash = new int[26];

        for(int i= 0; i<s.length(); i++){
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for(int a : hash){
            if(a!=0)
            return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // Arrays.sort(strs);
        // System.out.println(Arrays.toString(strs));
        List<List<String>> list = new ArrayList<>();
        boolean [] added = new boolean[strs.length];
        
        for(int i=0; i<strs.length; i++){
            if(added[i])
            continue;

            List<String> row = new ArrayList<>();
            added[i] = true;
            row.add(strs[i]);

            for(int j=i+1; j<strs.length; j++){
                if(added[j])
                 continue;
                if(strs[i].length() == strs[j].length() && isAna(strs[i] , strs[j])){
                    added[j] = true;
                    row.add(strs[j]);
                }
            }
            list.add(row);
        }
        return list;
    }
}