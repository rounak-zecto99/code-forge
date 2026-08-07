class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        char[] ch = s.toCharArray();
        int back =0;
        int size =-1;
        
        for(int i=0 ; i<ch.length;i++){
            
            if(map.containsKey(ch[i])){
            map.put(ch[i],map.get(ch[i])+1);
                
            }
            else{
                map.put(ch[i],1);
            }
            
       
            
            while(map.size()>k){
                char left = ch[back++];
                
                map.put(left,map.get(left)-1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
            }
            
                 if(map.size() == k){
                size = Math.max(size,i - back +1);
            }

        }
        return size;
        }
        
    }
