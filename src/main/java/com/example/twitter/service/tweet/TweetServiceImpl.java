package com.example.twitter.service.tweet;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.twitter.dto.TweetDTO;
import com.example.twitter.exception.NotFoundException;
import com.example.twitter.mappers.TweetMapper;
import com.example.twitter.model.TweetModel;
import com.example.twitter.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;
	
	@Override
	public TweetDTO getTweetById(String tweetId) {
		
		TweetModel model = tweetRepository.findById(tweetId).orElseThrow(NotFoundException::new);
		return TweetMapper.INSTANCE.tweetToTweetDto(model);
	}

	@Override
	public List<TweetDTO> getTweets(Integer page, Integer size, Boolean validated) {
		
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.ASC, "id"));
		Page<TweetModel> resultList;
		
		if(validated == null) {
			resultList = tweetRepository.findAll(pageRequest);
		
		}else {
			resultList = tweetRepository.findByValidated(validated, pageRequest);
		}
		
		return resultList.stream().map(TweetMapper.INSTANCE::tweetToTweetDto).collect(Collectors.toList());
	}
	
	@Override
	public TweetDTO saveTweet(TweetDTO tweet) {
		
		TweetModel model = TweetMapper.INSTANCE.tweetDTOToTweetModel(tweet);
		TweetModel saved = tweetRepository.save(model);
		return TweetMapper.INSTANCE.tweetToTweetDto(saved);
	}

	@Override
	public void updateValidated(String tweetId, boolean validated) {
		TweetDTO tweet = getTweetById(tweetId);
		tweet.setValidated(validated);
		saveTweet(tweet);
	}

	

}
