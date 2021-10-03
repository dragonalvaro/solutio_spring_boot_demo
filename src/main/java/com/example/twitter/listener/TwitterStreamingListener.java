package com.example.twitter.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.twitter.service.status.StatusService;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

@Component
public class TwitterStreamingListener {
	
	private static final Logger log = LoggerFactory.getLogger(TwitterStreamingListener.class);
	
	@Value("${twitter.app.minFollowers:1500}")
	private int minFollowers;

	@Value("#{'${twitter.app.allowedLanguages}'.split(',')}") 
	private List<String> allowedLanguages;

	@Autowired
	private TwitterStream twitterStream;
	
	@Autowired
	private StatusService statusService;
	
	public void streamFeed() {

		StatusListener listener = new StatusListener() {

			@Override
			public void onStatus(Status status) {
				
				status.getText();
				int followers = status.getUser().getFollowersCount();
				String language = status.getLang();
				
				if(followers > minFollowers && allowedLanguages.contains(language)) {
					statusService.convertAndSaveStatus(status);
					log.debug("Saved new tweet with text: {}", status.getText());
				}
			}
			
			@Override
			public void onException(Exception e) {
				log.error("Error on TwitterStreamListener: {}", e.getMessage());
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg) {
				//Not needed
			}

			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				//Not needed
			}

			@Override
			public void onStallWarning(StallWarning warning) {
				//Not needed
			}


			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				//Not needed
			}
		};

		twitterStream.addListener(listener);
		twitterStream.sample();
	}
}
