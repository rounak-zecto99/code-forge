class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
         helper(list,new ArrayList<>(),s,0);
         return list;
    }
    public void helper(List<List<String>> list, List<String> curr,String s, int index){
        if(index == s.length()){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i= index; i<s.length(); i++){
             String part = s.substring(index, i + 1);
              if(pall(part)){
                curr.add(part);
                helper(list,curr,s,i+1);
                curr.remove(curr.size()-1);
              }
        }
    }
    public boolean pall(String s){
        char [] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left] != arr [right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}