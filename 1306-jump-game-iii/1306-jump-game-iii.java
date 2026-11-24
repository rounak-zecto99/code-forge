class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {

        if (start < 0 || start >= arr.length || visited[start])
            return false;

        if (arr[start] == 0)
            return true;

        visited[start] = true;

        return dfs(arr, start + arr[start], visited)
            || dfs(arr, start - arr[start], visited);
    }
}