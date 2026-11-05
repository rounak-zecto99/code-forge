class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int good = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean g = true;
            int element = arr1[i];

            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr2[j] - element) <= d) {
                    g = false;
                    break;
                }
            }
            if (g)
                good++;
        }
        return good;
    }
}