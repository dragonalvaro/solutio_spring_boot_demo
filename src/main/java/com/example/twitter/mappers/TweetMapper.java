package com.example.twitter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.twitter.dto.TweetDTO;
import com.example.twitter.model.TweetModel;

@Mapper
public interface TweetMapper {

	TweetMapper INSTANCE = Mappers.getMapper(TweetMapper.class);
	
	TweetDTO tweetToTweetDto(TweetModel tweet);
	
	TweetModel tweetDTOToTweetModel(TweetDTO tweetDTO);
}
