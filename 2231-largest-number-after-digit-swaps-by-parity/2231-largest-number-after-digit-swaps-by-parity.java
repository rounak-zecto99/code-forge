class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> parity = new ArrayList<>();

        int n = num;
    
        while(num > 0){
            int cur = num % 10;

            if((cur&1) == 0){
                parity.add(0);
                even.offer(cur);
            }
            else{
                parity.add(1);
                odd.offer(cur);
            }
            num = num /10;
        }
        int ans = 0;
        int temp;

        for(int i = parity.size()-1; i>=0 ; i--){
            if(parity.get(i) == 0){
                temp = even.poll();
                ans = ans * 10 + temp;
            }
            else{
                temp = odd.poll();
                ans = ans * 10 + temp;
            }
        }
        return ans;
    }
}