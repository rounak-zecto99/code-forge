class Solution {
    public void prevSmaller(int[] arr, int[] pse) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

    }

    public void nextSmaller(int[] arr, int[] nse) {

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n ;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

    }

    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int[] nse = new int[arr.length];
        int[] pse = new int[arr.length];
        prevSmaller(arr, pse);
        nextSmaller(arr, nse);

        // System.out.println(Arrays.toString(pse));
        // System.out.println(Arrays.toString(nse));


        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            long prev = i - pse[i];
            long next = nse[i] - i;

            long count = (prev * next) % mod;
            ans = (ans + ((long) arr[i] * count) % mod) % mod;
        }

        return (int) ans;
    }
}