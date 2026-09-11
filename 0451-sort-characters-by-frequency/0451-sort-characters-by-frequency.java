class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        // int [][] ans = new int[n][2];
        int [][] hash = new int[128][2];
        for(char ch:s.toCharArray()){
            hash[ch][0] = ch;
            hash[ch][1]++;
        }
        Arrays.sort(hash,(a,b) -> Integer.compare(b[1],a[1]));
        // System.out.println(Arrays.deepToString(hash));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< hash.length; i++){
            char curr = (char)(hash[i][0]);
            int freq = hash[i][1];

            if(freq == 0)
            break;

            while(freq-->0){
                sb.append(curr);
            }
        }
        return sb.toString();
        
    }
}