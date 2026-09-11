class Solution {
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits);
      boolean []used = new boolean [digits.length];
      return helper(digits,0,used);  
    }
    public int helper(int[]digits,int num, boolean[]used){
        if(num>=100){
            return num%2==0?1:0;
        }
        int count = 0;
        for(int i = 0; i<digits.length; i++){
            if(used[i])
            continue;
            
            if(num == 0 && digits[i] == 0)
            continue;

            if(i>0 && digits[i] == digits[i-1] && !used[i-1])
             continue;

            used[i] = true;

            count+= helper(digits,num*10+digits[i],used);

            used[i] = false;
        }
        return count;
    }
}