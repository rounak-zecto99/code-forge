class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {

        int n = s.length;
        int[][] meetings = new int[n][3];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = s[i];
            meetings[i][1] = f[i];
            meetings[i][2] = i + 1;
        }

        // Sort by finish time, then by index
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[2], b[2]);
        });

        ArrayList<Integer> ans = new ArrayList<>();

        int lastEnd = -1;

        for(int i=0; i<s.length; i++){
        if(lastEnd<meetings[i][0]){
            lastEnd = meetings[i][1];
            ans.add(meetings[i][2]);
        }
        }


        Collections.sort(ans);
        return ans;
    }
}
