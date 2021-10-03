package com.example.twitter.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TrendsApiImpl implements TrendsApi {

	private static final Logger log = LoggerFactory.getLogger(TrendsApiImpl.class);

	@Value("${twitter.config.spainWOEID}")
	private int spainWOEID;

	@Autowired
	private Twitter twitter;

	@Override
	public List<Trend> getTopTrends() {

		try {
			Trends trends = twitter.getPlaceTrends(spainWOEID);
			return Arrays.asList(trends.getTrends());

		} catch (TwitterException te) {
			log.error("Error retrieving trends for woeid {}: {}", spainWOEID, te.getMessage());
			return Collections.emptyList();
		}
	}

	
	/** If you need a different location, use this method **/
	private int getWOEIDForLocation(String locationString) {

		try {
			ResponseList<Location> locations = twitter.getAvailableTrends();
			Location foundLocation = locations.stream().filter(location -> locationString.equals(location.getName()))
										   .findFirst()
										   .orElseThrow(() -> new TwitterException("Can't find location with name: "+locationString));
			return foundLocation.getWoeid();
		} catch (TwitterException te) {
			log.error("Failed to get trends: {}",te.getMessage());
			return 0;
		}
	}
}
