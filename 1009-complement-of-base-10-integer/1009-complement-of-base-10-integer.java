class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int digit = (int) (Math.log(n)/Math.log(2))+1;

        int []count = new int [digit];
        for(int i=0 ; i<digit ; i++){
            count[(digit-1) -i] = ((n>>i)&1)^1;
        }
        int ans = 0;
        for(int j =0; j<digit ; j++){
            ans = (ans<<1)|count[j];
        }
        return ans;
    }
}