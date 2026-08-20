class Solution {
    public String minWindow(String s, String t) {
        //  int[] freq = new int[128];
        //  for(int n : t.toCharArray()){
        //     freq[n-'A']++;
        //  }
        HashMap <Character,Integer> need = new HashMap<>();
        HashMap <Character,Integer> have = new HashMap<>();

        for(char n: t.toCharArray()){
            need.put(n, need.getOrDefault(n,0)+1);
        }
        int start =-1;
        int end =s.length();
        int left = 0;
        int size =0;
        int req = t.length();
    
    for(int right=0; right<s.length(); right++){
        char ch = s.charAt(right);

        if(need.containsKey(ch)){
        have.put(ch,have.getOrDefault(ch,0)+1);

        if(have.get(ch)<=need.get(ch))
        req --;
        }
        while(req == 0){
         char back = s.charAt(left);
         if(!need.containsKey(back)){
            left++;
         }
         else if(have.get(back)>need.get(back)){
            have.put(back,have.get(back)-1);
            left++;
         }
         else{
            if (start == -1 || right - left < end - start) {
                        start = left;
                        end = right;
                    }
            break;
         }
        }

    }
   

    if(start != -1)
    return s.substring(start,end+1);

    return "";

    }
}