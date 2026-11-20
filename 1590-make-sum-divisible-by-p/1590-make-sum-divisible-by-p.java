class Solution {
    public int minSubarray(int[] nums, int p) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, k -> new ArrayList<>()).add(0);

        //0 for suffix only divisibility

        int preSum = 0;
        int taken = 0;

        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            preSum = (preSum + nums[i]) % p;

            if (preSum % p == 0)
                taken = i + 1;

            map.computeIfAbsent(preSum, k -> new ArrayList<>()).add(i + 1);
        }

        int sufsum = 0;

        for (int i = n - 1; i >= 0; i--) {

            sufsum = (sufsum + nums[i]) % p;

            int rem = (p - sufsum) % p;

            if (map.containsKey(rem)) {

                ArrayList<Integer> list = map.get(rem);
                int last = list.size() - 1;

                while (last >= 0 && list.get(last) > i) { //list.get(last) + n - i > n
                    list.remove(last); //pulls out all the stale element
                    last--;
                }

                if (last >= 0) {
                    int nu = list.get(last) + n - i;

                    if (nu == n)
                        return 0;

                    taken = Math.max(taken, nu);
                }

            }

        }
        return taken == 0 ? -1 : n - taken;
    }
}