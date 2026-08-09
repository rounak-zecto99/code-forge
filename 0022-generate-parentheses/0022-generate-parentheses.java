class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
         helper(list,"(",1,0,n);
         return list;
    }
   void helper(List<String> list, String s, int open, int close, int length){
     if(s.length() == 2*length){
        list.add(s);
        return;
     }
     if(open<length){
        helper(list,s+"(",open+1,close,length);
     }
     if(close<open){
     helper(list,s+")",open,close+1,length);
    }
   }
}