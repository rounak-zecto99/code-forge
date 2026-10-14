class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] inDegree = new int[n];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] ar : prerequisites) {
            int end = ar[0];
            int start = ar[1];
            list.get(start).add(end);
            inDegree[end]++;
        }

        int total = 0;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        // System.out.println(Arrays.toString(inDegree));

        while (!q.isEmpty()) {  //Kahns Algo
            int node = q.poll();
            ++total;

            for (int i : list.get(node)) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return total == numCourses;
    }
}