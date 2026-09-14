
class Solution {
    public void mergeArrays(int a[], int b[]) {

        int n = a.length;
        int m = b.length;

        int i = n - 1;  // last element of a
        int j = 0;      // first element of b

        while (i >= 0 && j < m) {

            if (a[i] > b[j]) {

                // swap
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;

                i--;
                j++;

            } else {
                i--;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
}