class Solution {
    public int minimumRightShifts(List<Integer> list) {
        int s = list.size();
        int bp = -1;

        for (int i = 0; i < s - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                if (bp != -1)
                    return -1;
                bp = i;
            }

        }

        if (bp == -1)
            return 0;

        if (list.get(s - 1) > list.get(0))
            return -1;

        return s - bp - 1;
    }
}