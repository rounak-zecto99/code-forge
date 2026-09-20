class Solution {
    public int maxBitonic(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i]
                    + expandleft(arr, i)
                    + expandright(arr, i);

            max = Math.max(max, sum);
        }

        return max;
    }

    public int expandleft(int[] arr, int i) {
        int sum = 0;
        int left = i - 1;

        // First find the complete non-decreasing part
        while (left >= 0 && arr[left] <= arr[left + 1]) {
            sum += arr[left];
            left--;
        }

        // Remove equal elements from the beginning.
        // The first transition must be a strict increase.
        while (left + 1 < i && arr[left + 1] == arr[left + 2]) {
            sum -= arr[left + 1];
            left++;
        }

        return sum;
    }

    public int expandright(int[] arr, int i) {
        int sum = 0;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[j - 1]) {
                sum += arr[j];
            } else {
                break;
            }
        }

        return sum;
    }
}