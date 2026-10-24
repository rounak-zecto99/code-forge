class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        TreeMap<Integer, Integer> distance = new TreeMap<>();
        distance.put(0, 0);

        for (int[] duration : flowers) {
            int start = duration[0];
            int end = duration[1] + 1;

            distance.put(start, distance.getOrDefault(start, 0) + 1);
            distance.put(end, distance.getOrDefault(end, 0) - 1);
        }

        int psum = 0;

        ArrayList<Integer> position = new ArrayList<>();
        ArrayList<Integer> presum = new ArrayList<>();

        for (int time : distance.keySet()) {
            position.add(time);
            psum += distance.get(time);
            presum.add(psum);
        }

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int cur = bsFloor(position, people[i]);
            ans[i] = presum.get(cur);
        }
        return ans;
    }

    int bsFloor(ArrayList<Integer> position, int target) {
        int start = 0;
        int end = position.size() - 1;

        while (start < end) {
            int mid = start + (end - start + 1) / 2;

            if (position.get(mid) == target) {
                return mid;
            } else if (position.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }
}