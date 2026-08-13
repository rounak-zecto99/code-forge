class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String [] letter = {
            "",
            "",
           "abc",
           "def",
           "ghi",
           "jkl",
           "mno",
           "pqrs",
           "tuv",
           "wxyz"
        };
         helper(list, new StringBuilder() , letter, digits, 0);
         return list;
    }
    public void helper( List<String> list, StringBuilder s, String []letter, String digits, int index){
          if(index == digits.length()){
            list.add(s.toString());
            return;
          }

        String curr = letter[digits.charAt(index) - '0'] ;

        for(int i=0; i<curr.length(); i++){
            char ch = curr.charAt(i);
             s.append(ch);
             helper(list, s , letter, digits, index+1);
             s.deleteCharAt(s.length()-1);
        }
    }
}