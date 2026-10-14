class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int total = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            total++;

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return total == numCourses;
    }
}