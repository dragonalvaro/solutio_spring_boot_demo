package com.example.twitter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.twitter.model.TweetModel;

public interface TweetRepository extends MongoRepository<TweetModel, String>{

	/**
	 * Find tweets with the field validated as requested
	 * @param validated
	 * @param pageRequest
	 * @return
	 */
	Page<TweetModel> findByValidated(Boolean validated, PageRequest pageRequest);
}
