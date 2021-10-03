package com.example.twitter.service.tweet;

import java.util.List;

import com.example.twitter.dto.TweetDTO;

/**
 * Service to manage operations over Tweets.
 * Allows to save, get and validate Tweets
 * @author alvaro
 *
 */
public interface TweetService {

	/**
	 * Returns the Tweet (if exists) given an ID
	 * @param tweetId
	 * @return
	 */
	TweetDTO getTweetById(String tweetId);

	/**
	 * Persist the tweet on the database
	 * @param tweet
	 * @return
	 */
	TweetDTO saveTweet(TweetDTO tweet);

	/**
	 * Updates the field 'validated' to the given value 
	 * @param tweetId
	 */
	void updateValidated(String tweetId, boolean validated);

	/**
	 * Returns a paginated list of tweets
	 * 'validated' its optional
	 * If no value is passed on validated field, it will returns tweets with both values
	 * 
	 * @param page
	 * @param size
	 * @param validated
	 * @return
	 */
	List<TweetDTO> getTweets(Integer page, Integer size, Boolean validated);

	
}
