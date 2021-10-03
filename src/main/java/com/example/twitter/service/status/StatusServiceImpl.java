package com.example.twitter.service.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twitter.dto.TweetDTO;
import com.example.twitter.mappers.StatusMapper;
import com.example.twitter.service.tweet.TweetService;

import twitter4j.Status;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private TweetService tweetService;
	
	@Override
	public void convertAndSaveStatus(Status status) {
		TweetDTO tweet = StatusMapper.INSTANCE.statusToTweetDTO(status);
		tweetService.saveTweet(tweet);
	}
}
