package com.example.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.twitter.dto.HashtagDTO;
import com.example.twitter.service.hashtag.HashtagService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

	@Autowired
	private HashtagService hashtagService;

	@Operation(summary = "Retrieves a list of the top trending hashtags from a location. Location its setted on properties")
	@GetMapping(value = "/top")
	public List<HashtagDTO> getTweetById(
			@Parameter(description = "Value beetween 1 and 50. Defines the size of the result list") @RequestParam int size) {

		Assert.isTrue(size > 0 && size <= 50, "Size must be beetween 1 and 50");

		return hashtagService.getTopHashtags(size);
	}
}
