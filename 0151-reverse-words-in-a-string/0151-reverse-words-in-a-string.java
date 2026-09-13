class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        // 1. Remove extra spaces
        int n = cleanSpaces(arr);

        // 2. Reverse entire string
        reverse(arr, 0, n - 1);

        // 3. Reverse each word
        int start = 0;

        for (int end = 0; end <= n; end++) {
            if (end == n || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }

        return new String(arr, 0, n);
    }

    private int cleanSpaces(char[] arr) {
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            while (right < arr.length && arr[right] == ' ') {
                right++;
            }

            while (right < arr.length && arr[right] != ' ') {
                arr[left++] = arr[right++];
            }

            while (right < arr.length && arr[right] == ' ') {
                right++;
            }

            if (right < arr.length) {
                arr[left++] = ' ';
            }
        }

        return left;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}