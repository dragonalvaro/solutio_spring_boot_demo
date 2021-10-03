package com.example.twitter.service.hashtag;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twitter.api.TrendsApi;
import com.example.twitter.dto.HashtagDTO;
import com.example.twitter.mappers.HashtagMapper;

@Service
public class HashtagServiceImpl implements HashtagService {

	@Autowired
	private TrendsApi trendsApi;
	
	@Override
	public List<HashtagDTO> getTopHashtags(int max){
		
		 return trendsApi.getTopTrends().stream()
				 						.limit(max)
		 						        .map(HashtagMapper.INSTANCE::trendToHashtagDTO)
		 						        .collect(Collectors.toList());
	}
}
