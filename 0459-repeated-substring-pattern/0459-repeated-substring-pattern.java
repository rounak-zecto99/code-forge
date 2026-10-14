class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //prime number concept;
        int n = s.length()>>1;

        for(int i=1; i<=n; i++){
            if((s.length() % i) == 0 ){
                int a = 0;
                int b = i;
                
                String first = s.substring(a,b);
                int k = 1;
                int end = (s.length() / i);
                
                while(k<end){
                    a = b;
                    b += i;
                    // System.out.print(s.substring(a,b));
                    if(!first.equals(s.substring(a,b))){
                        break;
                    }
                    k++;
                }
                if(k == end)
                    return true;                
            }
        }
        
        return false;
    }  
} 