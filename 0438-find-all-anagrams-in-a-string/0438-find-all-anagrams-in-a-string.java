class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> list = new ArrayList<>();
        int []need = new int [26];
        
        for(int n: p.toCharArray()){
            need[n - 'a']++;
        }
        int left = 0;
        int req = p.length();

        for(int i=0;i<s.length();i++){
            int a = s.charAt(i);

            if(need[a-'a']>0)
            req--;

            need[a-'a']--;

            if(i-left+1>p.length()){
                int last = s.charAt(left++);
                 need[last-'a']++;

                 if(need[last-'a']>0)
                    req++;
            }
            if(req == 0){
                list.add(left);
            }
            }         

        return list;
    }
}