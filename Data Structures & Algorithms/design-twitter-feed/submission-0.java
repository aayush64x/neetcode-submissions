
class Twitter {
    int count = 0;
    HashMap<Integer, List<Integer>> tweets;
    HashMap<Integer, Set<Integer>> followers;
    HashMap<Integer, Integer> timePublished;
    HashMap<Integer, Integer> tweetOwner;

    public Twitter() {
        this.tweets = new HashMap<>();
        this.followers = new HashMap<>();
        this.tweetOwner = new HashMap<>();
        this.timePublished = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        count++;

        if (tweets.containsKey(userId)) {
            List<Integer> list = tweets.get(userId);
            list.add(tweetId);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(tweetId);
            tweets.put(userId, list);
        }

        timePublished.put(tweetId, count);
        tweetOwner.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = new HashSet<>(
            followers.getOrDefault(userId, new HashSet<>())
        );

        follows.add(userId);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                timePublished.get(b), timePublished.get(a)
            )
        );

        for (int followee : follows) {
            if (tweets.containsKey(followee)) {
                maxHeap.addAll(tweets.get(followee));
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!maxHeap.isEmpty() && list.size() < 10) {
            list.add(maxHeap.poll());
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
