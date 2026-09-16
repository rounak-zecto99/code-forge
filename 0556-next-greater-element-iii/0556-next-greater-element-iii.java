class Solution {
    public void reverse(List<Integer> list, int left, int right) {

        while (left < right) {
            int temp = list.get(right);
            list.set(right, list.get(left));
            list.set(left, temp);

            left++;
            right--;
        }
    }

    public int maker(List<Integer> list,int n) {

        long ans = 0;

        for (int i = 0; i < list.size(); i++) {
            ans = ans * 10 + list.get(i);
        }
        if (ans > Integer.MAX_VALUE || ans<n)
            return -1;

        return (int) ans;
    }

    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        int curr = n;

        while (curr > 0) {
            list.add(curr % 10);
            curr /= 10;
        }
        Collections.reverse(list);

        int index = -1;
        int size = list.size() - 1;

        for (int i = size - 1; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Collections.reverse(list);
            return maker(list,n);
        }
        for (int j = size; j > index; j--) {
            if (list.get(j) > list.get(index)) {
                int temp = list.get(index);
                list.set(index, list.get(j));
                list.set(j, temp);
                break;
            }
        }
        reverse(list, index + 1, size);
        return maker(list,n);

    }
}