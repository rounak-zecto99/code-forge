class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //first select row
        int cfloor = floor(matrix, target, m - 1);

        System.out.println(cfloor);

        if (cfloor == -1)
            return false;

        if (matrix[cfloor][0] == target)
            return true;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (matrix[cfloor][mid] == target) {
                return true;
            } else if (matrix[cfloor][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    int floor(int[][] matrix, int target, int end_col) {
        int start_col = 0;
        int rceil = -1;

        while (start_col <= end_col) {
            int mid = start_col + ((end_col - start_col) >> 1);

            if (matrix[mid][0] > target) {
                end_col = mid - 1;
            } else {
                rceil = mid;
                start_col = mid + 1;
            }
        }
        return rceil;
    }
}