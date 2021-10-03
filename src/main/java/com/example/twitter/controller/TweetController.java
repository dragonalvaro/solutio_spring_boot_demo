package com.example.twitter.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.twitter.dto.TweetDTO;
import com.example.twitter.service.tweet.TweetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/tweets")
public class TweetController {

	private static final Logger log = LoggerFactory.getLogger(TweetController.class);

	private static final String DEFAULT_SIZE = "15";
	private static final String DEFAULT_PAGE = "0";

	@Autowired
	private TweetService tweetService;

	@Operation(summary = "Get a list of tweets. Using validated its optinal")
	@GetMapping(value = "/")
	public List<TweetDTO> getTweets(@RequestParam(defaultValue = DEFAULT_PAGE) Integer page,
			@RequestParam(defaultValue = DEFAULT_SIZE) Integer size,
			@Parameter(description = "Optional parameter") @RequestParam(required = false) Boolean validated) {

		log.debug("Recieved request on getTweets with values {}, {}, {}", page, size, validated);

		return tweetService.getTweets(page, size, validated);

	}

	@Operation(summary = "Get a tweet by given ID")
	@GetMapping(value = "/{tweetId}")
	public TweetDTO getTweetById(@Parameter(description = "The internal tweetId") @PathVariable String tweetId) {

		Assert.isTrue(ObjectId.isValid(tweetId), "Invalid internal tweet ID");

		log.debug("Recieved request on getTweetById with value {}", tweetId);
		return tweetService.getTweetById(tweetId);

	}

	@Operation(summary = "Updates the field 'validated' to the input value")
	@PatchMapping(value = "/validate/{tweetId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateValidated(@PathVariable String tweetId,
			@Parameter(description = "Can be true or false") @RequestParam(defaultValue = "true") boolean validated) {

		Assert.isTrue(ObjectId.isValid(tweetId), "Invalid internal tweet ID");

		log.debug("Recieved request on validateTweet with value {}", tweetId);
		tweetService.updateValidated(tweetId, validated);
	}

}
