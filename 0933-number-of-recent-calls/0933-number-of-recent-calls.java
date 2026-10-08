class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.poll();
        }
        q.offer(t);
        return q.size();
    }
}