class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ans = new int[numCourses];
        int fill = -1;
        int [] inDegree = new int[numCourses];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for(int [] ar : prerequisites){
            int start = ar[1];
            int end = ar[0];

            list.get(start).add(end);
            inDegree[end]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[++fill] = node;

            for(int i : list.get(node)){
                inDegree[i]--;

                if(inDegree[i] == 0){
                    q.offer(i);
                }
            }
        }
        if(fill + 1 == numCourses)
        return ans;

        return new int[]{};
    }
}