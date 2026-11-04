import java.util.*;

class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();

    int s = 0, l = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);

            if (i >= k) {
                remove(nums[i - k]);
            }

            if (i >= k - 1) {
                ans[i - k + 1] = median(k);
            }
        }

        return ans;
    }

    void add(int num) {
        if (small.isEmpty() || num <= small.lastKey()) {
            small.merge(num, 1, Integer::sum);
            s++;
        } else {
            large.merge(num, 1, Integer::sum);
            l++;
        }

        balance();
    }

    void remove(int num) {
        if (num <= small.lastKey()) {
            removeFrom(small, num);
            s--;
        } else {
            removeFrom(large, num);
            l--;
        }

        balance();
    }

    void removeFrom(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    void balance() {
        while (s > l + 1) {
            int num = small.lastKey();

            removeFrom(small, num);
            large.merge(num, 1, Integer::sum);

            s--;
            l++;
        }

        while (s < l) {
            int num = large.firstKey();

            removeFrom(large, num);
            small.merge(num, 1, Integer::sum);

            s++;
            l--;
        }
    }

    double median(int k) {
        if (k % 2 == 1) {
            return small.lastKey();
        }

        return ((long) small.lastKey() + large.firstKey()) / 2.0;
    }
}