class Solution {
    public void reverse(int[] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = i + 1; j < matrix.length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }
}