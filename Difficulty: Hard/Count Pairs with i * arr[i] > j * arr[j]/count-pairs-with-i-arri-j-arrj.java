class Solution {

    public int countPairs(List<Integer> arr) {
        int[] product = new int[arr.size()];
        int[] count = {0};

        for (int i = 0; i < arr.size(); i++) {
            product[i] = i * arr.get(i);
        }

        mergeSort(product, count);

        return count[0];
    }

    public int[] mergeSort(int[] arr, int[] count) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(
            Arrays.copyOfRange(arr, 0, mid),
            count
        );

        int[] right = mergeSort(
            Arrays.copyOfRange(arr, mid, arr.length),
            count
        );

        return merge(left, right, count);
    }

    public int[] merge(int[] left, int[] right, int[] count) {

        int[] ans = new int[left.length + right.length];

        int l = 0, r = 0, k = 0;

        while (l < left.length && r < right.length) {

            if (left[l] > right[r]) {
                ans[k++] = right[r++];
                count[0] += left.length - l;
            } else {
                ans[k++] = left[l++];
            }
        }

        while (l < left.length) {
            ans[k++] = left[l++];
        }

        while (r < right.length) {
            ans[k++] = right[r++];
        }

        return ans;
    }
}