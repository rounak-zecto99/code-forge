class Solution {
    public boolean isVal(String s){
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
            return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
       helper(list, new ArrayList<>(), 0 ,s);
        return list;
    }
    public void helper(List<List<String>> list, List<String> row, int index, String s){
        if(index == s.length()){
            list.add(new ArrayList<>(row));
            return;
        }

        for(int i=index; i<s.length() ; i++){
            String cur = s.substring(index,i+1);
            if(isVal(cur)){
                row.add(cur);
                helper(list, row, i+1 ,s);
                row.remove(row.size()-1);
            }
        }
    }
}