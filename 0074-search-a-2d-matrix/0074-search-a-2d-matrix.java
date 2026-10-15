
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = findRow(matrix, target, m - 1);

        if (row == -1) {
            return false;
        }

        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    int findRow(int[][] matrix, int target, int end) {
        int start = 0;
        int row = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target) {
                row = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return row;
    }
}
