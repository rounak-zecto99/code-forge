class Solution {
    public int jumpyBall(int h) {
     return h==0?0:2*h+jumpyBall(h/2);
    }
}