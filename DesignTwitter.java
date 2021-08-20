import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * LeetCode 355 Medium
 * 
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, 
and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. 
Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. 
Each item in the news feed must be posted by users who the user followed or by the user themself. 
Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 
Example 1:
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]

Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 
Constraints:

1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 10^4
All the tweets have unique IDs.
At most 3 * 10^4 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
 */
public class DesignTwitter {
	class Twitter {
	    
	    private int timeStamp = 0;
	    private Map<Integer, User> userMap; // <UserId, User>    
	    private class Tweet {
	        public int id;
	        public int time;
	        public Tweet next;
	        
	        public Tweet(int id) {
	            this.id = id;
	            time = timeStamp++;
	            next = null;
	        }
	    }
	    
	    public class User {
	        public int userId;
	        public Set<Integer> followed;
	        public Tweet tweet_head;
	        
	        public User(int userId) {
	            this.userId = userId;
	            followed = new HashSet<>();
	            follow(userId); // follow himself
	            tweet_head = null;
	        }
	        public void follow(int userId) {
	            followed.add(userId);
	        }
	        public void unfollow(int userId) {
	            followed.remove(userId);
	        }
	        public void post(int tweetId) {
	            Tweet t = new Tweet(tweetId);
	            t.next = tweet_head;
	            tweet_head = t;
	        }
	    }
	    /** Initialize your data structure here. */
	    public Twitter() {
	        userMap = new HashMap<>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        if (!userMap.containsKey(userId)) {
	            User new_User = new User(userId);
	            userMap.put(userId, new_User);
	        }
	        userMap.get(userId).post(tweetId);
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        if (!userMap.containsKey(userId))
	            return new ArrayList<>();
	        List<Integer> res = new ArrayList<>();
	        Set<Integer> users = userMap.get(userId).followed;
	        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));
	        for (int user : users) {
	            Tweet tweetHead = userMap.get(user).tweet_head;
	            if (tweetHead != null)
	                pq.add(tweetHead);
	        }
	        int cnt = 0;
	        while (!pq.isEmpty() && cnt < 10) {
	            Tweet tweetHead = pq.poll(); 
	            res.add(tweetHead.id);
	            if (tweetHead.next != null)
	                pq.add(tweetHead.next);
	            cnt++;
	        }
	        return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if (!userMap.containsKey(followerId)) {
	            User u = new User(followerId);
	            userMap.put(followerId, u);
	        }
	        if (!userMap.containsKey(followeeId)) {
	            User u = new User(followeeId);
	            userMap.put(followeeId, u);
	        }
	            
	        userMap.get(followerId).follow(followeeId);
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if (!userMap.containsKey(followerId)) {
	            User u = new User(followerId);
	            userMap.put(followerId, u);
	        }
	        if (!userMap.containsKey(followeeId)) {
	            User u = new User(followeeId);
	            userMap.put(followeeId, u);
	        }            
	        userMap.get(followerId).unfollow(followeeId);
	    }
	}
}
