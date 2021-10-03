package com.example.twitter.service.status;

import twitter4j.Status;

public interface StatusService {

	void convertAndSaveStatus(Status status);

}
