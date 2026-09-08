class Solution {
    public int countVowelSubstrings(String word) {
        return atMost(word,5) - atMost(word,4);
    }
    public boolean isVowel(char c){
        return (c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    public int atMost(String word,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int count = 0;

        for(int i=0; i<word.length(); i++){
            char cur = word.charAt(i);
            if(!isVowel(cur)){
                left = i + 1;
                map.clear();
            }
            else{
                map.put(cur,map.getOrDefault(cur,0)+1);

                while(map.size()>k){
                    char last = word.charAt(left++);
                    map.put(last,map.get(last)-1);

                    if(map.get(last) == 0)
                    map.remove(last);
                }
                count+=i-left+1;
            }
        }
        return count;
    }
}