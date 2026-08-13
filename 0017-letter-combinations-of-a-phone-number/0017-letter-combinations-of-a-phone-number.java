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
         helper(list, "" , letter, digits, 0);
         return list;
    }
    public void helper( List<String> list, String s, String []letter, String digits, int index){
          if(index == digits.length()){
            list.add(s);
            return;
          }

        String curr = letter[digits.charAt(index) - '0'] ;

        for(int i=0; i<curr.length(); i++){
            char ch = curr.charAt(i);
             helper(list, s+ch , letter, digits, index+1);
        }
    }
}