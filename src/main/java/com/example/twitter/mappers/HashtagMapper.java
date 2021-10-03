package com.example.twitter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.twitter.dto.HashtagDTO;

import twitter4j.Trend;

@Mapper
public interface HashtagMapper {

	HashtagMapper INSTANCE = Mappers.getMapper(HashtagMapper.class);
	
	HashtagDTO trendToHashtagDTO(Trend trend);
	
}
