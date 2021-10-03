package com.example.twitter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.twitter.dto.TweetDTO;

import twitter4j.Status;

@Mapper
public interface StatusMapper {

	StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

	@Mapping(source = "text", target = "text")
	@Mapping(source = "user.name", target = "user")
	@Mapping(source = "user.location", target = "userLocation")
	@Mapping(source = "geoLocation", target = "geoLocation")
	@Mapping(source = "id", target = "twitterId")
	@Mapping(target = "id", ignore = true)
	TweetDTO statusToTweetDTO(Status status);
}
