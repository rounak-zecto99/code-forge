class Solution {
    public int mask(int n){
        int bit =0;
         while(n>0){
            if((n&1) == 1)
            bit++;
            n>>=1;
         }
        return bit;
    }
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int [][] ans = new int[n][2];

        for(int i=0; i<n;i++){
            int countof1 = mask(arr[i]);
            ans[i][0] = arr[i];
            ans[i][1] = countof1;
        }
        Arrays.sort(ans,(a,b) -> {
                    if(a[1]!=b[1])
                    return Integer.compare(a[1],b[1]);
                    return Integer.compare(a[0],b[0]);
                });
        // System.out.println(Arrays.deepToString(ans));
        int [] a = new int[n];

        for(int i=0; i<n ; i++){
            a[i] = ans[i][0];
        }
        return a;        
    }
}