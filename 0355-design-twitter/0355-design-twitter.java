class Tweet {
    int id;
    int time;
    Tweet next;

    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

class Twitter {

    private int time = 0;

    private Map<Integer, Tweet> tweets;

    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet head = tweets.get(userId);

        Tweet newTweet = new Tweet(tweetId, time++);

        newTweet.next = head;

        tweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }

        Set<Integer> followees = following.getOrDefault(userId, Collections.emptySet());

        for (int followee : followees) {

            Tweet head = tweets.get(followee);

            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {

            Tweet current = pq.poll();

            result.add(current.id);

            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following.computeIfAbsent(followerId,k -> new HashSet<>()).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> followees = following.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}