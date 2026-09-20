class Solution {
    public void swap(int[] arr, int f, int e) {
        int temp = arr[f];
        arr[f] = arr[e];
        arr[e] = temp;
    }

    ArrayList<Integer> findTwoElement(int arr[]) {

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;

        while(i < arr.length) {
            int correct = arr[i] - 1;

            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }
            else {
                i++;
            }
        }

        for(int c = 0; c < arr.length; c++) {
            if(arr[c] - 1 != c) {
                list.add(arr[c]); // duplicate
                list.add(c + 1);  // missing
                return list;
            }
        }

        return list;
    }
}