class Solution {
    public int totalFruit(int[] fruits) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int left = 0;
        int basket = 0;

        for(int i=0; i<fruits.length; i++){
            map.put(fruits[i],i);

            if(map.size()>2){
                int fruit = fruits[left];
                left = Math.max(left,map.get(fruit)+1);
                map.remove(fruit);
                
            }
            basket = Math.max(basket,i-left+1);
        }
        return basket;
    }
}