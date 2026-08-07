class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keypad = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
};
String []arr = new String [digits.length()];
for(int i=0; i<arr.length; i++){
    arr[i]= keypad[digits.charAt(i)-'0'];
}
List <String> list = new ArrayList<>();
    helper("",arr,list);
    return list;
    }
    public void helper(String p,String[]key,List <String>list){
        if(key.length == 0){
            list.add(p);
            return;
        }
    String letter = key[0];
    for(int i=0; i<letter.length(); i++){
        char ch = letter.charAt(i);
         helper(p+ch,Arrays.copyOfRange(key,1,key.length),list);
    }
    }
}