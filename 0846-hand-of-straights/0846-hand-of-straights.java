class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length %groupSize !=0)
        return false;
    
    HashMap <Integer,Integer> map = new HashMap<>();
    PriorityQueue <Integer> heap = new PriorityQueue<>();

    for(int n : hand){
        map.put(n,map.getOrDefault(n,0)+1);
    }
    for(int a:map.keySet()){
        heap.offer(a);
    }
    while(!heap.isEmpty()){
        int start = heap.peek();

        for(int i=0; i<groupSize; i++){
            int card = start+i;
           if(map.getOrDefault(card,0) == 0)
           return false;
           map.put(card,map.get(card)-1);
        }
        while(!heap.isEmpty() && map.get(heap.peek()) == 0){
            heap.poll();
        }
    }
    return true;
    }
}