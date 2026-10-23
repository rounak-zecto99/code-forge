class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int sum = 0;

        for (int i = 1; i < requests.length; i++) {
            sum += Math.abs(requests[i - 1] - requests[i]);
        }
        sum += requests[0];

        return sum;
    }
}