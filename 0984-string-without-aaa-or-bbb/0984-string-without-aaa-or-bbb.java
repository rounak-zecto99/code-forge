class Solution {
    // public String strWithout3a3b(int a, int b) {

    //     StringBuilder sb = new StringBuilder();
    //     boolean ap = false;
    //     boolean bp = false;

    //     while (a != 0 && b != 0) {
    //         if (a - b >= 2 && !ap) {
    //             sb.append("aa");
    //             a-=2;
    //             ap=true;
    //             bp=false;
    //         }
    //         else if(b - a >= 2 && !bp){
    //             sb.append("bb");
    //             b-=2;
    //             bp=true;
    //             ap=false;
    //         }
    //         else if(a>b && !ap){
    //             sb.append('a');
    //             a--;
    //             bp=true;
    //             ap=false;
    //         }
    //         else if(b>a && !bp){
    //             sb.append('b');
    //             b--;
    //             bp=true;
    //             ap=false;
    //         }
    //         else if(!ap){
    //             sb.append('a'); 
    //             a--;
    //             ap=true;
    //             bp=false;
    //         }
    //         else{
    //             sb.append('b');
    //             b--;
    //             bp=true;
    //             ap=false;
    //         }
    //     }
    //     while(b!=0){
    //         sb.append('b');
    //         b--;
    //     }
    //     while(a!=0){
    //         sb.append('a');
    //         a--;
    //     }
    //     return sb.toString();
    // }
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) {
            a = 'b';
            b = 'a';
            i = B;
            j = A;
        }
        while (i-- > 0) {
            res.append(a);
            if (i > j) {
                res.append(a);
                --i;
            }
            if (j-- > 0)
                res.append(b);
        }
        return res.toString();
    }
}
