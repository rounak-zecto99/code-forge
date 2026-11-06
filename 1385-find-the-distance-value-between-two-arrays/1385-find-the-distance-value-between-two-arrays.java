class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int good = 0;

        for (int x : arr1) {
            int idx = lowerBound(arr2, x);

            boolean valid = true;

            if (idx < arr2.length && Math.abs(arr2[idx] - x) <= d) {
                valid = false;
            }

            if (idx > 0 && Math.abs(arr2[idx - 1] - x) <= d) {
                valid = false;
            }

            if (valid) {
                good++;
            }
        }

        return good;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}