class Solution {
    static String decToBinary(int n) {
        
        StringBuilder sb =new StringBuilder();
        while(n>0){
            sb.append((char)(n%2 + '0'));
            n/=2;
        }
        return sb.reverse().toString();
    }
}