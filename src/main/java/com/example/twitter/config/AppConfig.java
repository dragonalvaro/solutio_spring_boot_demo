package com.example.twitter.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class AppConfig {

	@Value("${twitter.config.apiKey}")
	private String twitterApiKey;
	
	@Value("${twitter.config.apiSecret}")
	private String twitterApiSecret;
	
	@Value("${twitter.config.token}")
	private String twitterToken;
	
	@Value("${twitter.config.tokenSecret}")
	private String twitterTokenSecret;
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
	}

	@Bean
	public TwitterStream twitterStream() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(twitterApiKey)
		  .setOAuthConsumerSecret(twitterApiSecret)
		  .setOAuthAccessToken(twitterToken)
		  .setOAuthAccessTokenSecret(twitterTokenSecret);
		
		return new TwitterStreamFactory(cb.build()).getInstance();
	}
	
	@Bean
	public Twitter twitterFactory() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(twitterApiKey)
		  .setOAuthConsumerSecret(twitterApiSecret)
		  .setOAuthAccessToken(twitterToken)
		  .setOAuthAccessTokenSecret(twitterTokenSecret);
		
		return new TwitterFactory(cb.build()).getInstance();
	}


}
