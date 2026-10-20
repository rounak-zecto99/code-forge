
import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] target = nums.clone();
        Arrays.sort(target);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int descents = 0;

                for (int i = start; i < start + k; i++) {
                    int next = (i + 1 == start + k)
                            ? start
                            : i + 1;

                    if (nums[i] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                // The block must also contain exactly the
                // elements of its corresponding sorted segment.
                int[] block = Arrays.copyOfRange(
                        nums, start, start + k);
                int[] sortedBlock = Arrays.copyOfRange(
                        target, start, start + k);

                Arrays.sort(block);

                if (!Arrays.equals(block, sortedBlock)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
