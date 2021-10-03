package com.example.twitter.service.status;

import twitter4j.Status;

/**
 * This service its intended for working between Status and our DTO TweetDTO
 * @author alvaro
 *
 */
public interface StatusService {

	void convertAndSaveStatus(Status status);

}
