class Solution {
    public String minWindow(String s, String t) {
        int [] need = new int[128];

        for(int n:t.toCharArray()){
            need[n]++;
        }
        int left=0;
        int start=0;
        int minLen = Integer.MAX_VALUE;
        int req = t.length();
        
        for(int right=0; right<s.length(); right++){
            int a = s.charAt(right);

            if(need[a]>0){
              req--;
            }
            need[a]--;
            while(req == 0){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                int last = s.charAt(left++);

                need[last]++;  //only goes to 0 or less when we have more than req

                if(need[last]>0)
                req++;
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}