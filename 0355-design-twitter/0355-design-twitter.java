import java.util.*;

class Twitter {

    private int timestamp = 0;

    // userId -> list of tweets posted by that user
    private Map<Integer, List<Tweet>> tweets;

    // userId -> set of users they follow
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Include the user's own tweets
        addTweets(userId, pq);

        // Include tweets from followed users
        Set<Integer> users = following.getOrDefault(
            userId, Collections.emptySet()
        );

        for (int followee : users) {
            addTweets(followee, pq);
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().id);
        }

        return result;
    }

    private void addTweets(int userId, PriorityQueue<Tweet> pq) {

        List<Tweet> userTweets = tweets.get(userId);

        if (userTweets == null) {
            return;
        }

        for (Tweet tweet : userTweets) {
            pq.offer(tweet);
        }
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> users = following.get(followerId);

        if (users != null) {
            users.remove(followeeId);
        }
    }
}