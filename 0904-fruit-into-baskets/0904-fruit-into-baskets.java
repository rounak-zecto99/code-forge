class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int left =0;

        for(int right=0; right<fruits.length; right++){
            if(map.containsKey(fruits[right])){
                map.put(fruits[right],map.get(fruits[right])+1);
            }
            else{
                map.put(fruits[right],1);
            }

            while(map.size()>2){
                int leftmost = fruits[left++];
               map.put(leftmost,map.get(leftmost)-1);

               if(map.get(leftmost) == 0){
                map.remove(leftmost);
               }
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}