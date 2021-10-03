package com.example.twitter.api;

import java.util.List;

import twitter4j.Trend;

public interface TrendsApi {

	/**
	 * Connects to Twitter api to retrieve top hashtags
	 * @return
	 */
	List<Trend> getTopTrends();
}
