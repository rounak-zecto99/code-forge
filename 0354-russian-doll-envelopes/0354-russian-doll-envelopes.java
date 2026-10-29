class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);

        for(int i=1; i<envelopes.length; i++){
            int last = list.get(list.size() - 1);

            if(last < envelopes[i][1]){
                list.add(envelopes[i][1]);
            }
            else{
                int start = 0;
                int end = list.size() - 1;

                while(start < end){
                    int mid = start + (end - start) /2;

                    if(list.get(mid) < envelopes[i][1]){
                        start = mid + 1;
                    }
                    else{
                        end = mid;
                    }
                }
                list.set(start,envelopes[i][1]);          
            }
        }
        return list.size();
    }
}