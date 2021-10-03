package com.example.twitter.service.hashtag;

import java.util.List;

import com.example.twitter.dto.HashtagDTO;

public interface HashtagService {

	/**
	 * Retrieves a list with the top trending hashtags at the moment
	 * @param max
	 * @return
	 */
	List<HashtagDTO> getTopHashtags(int max);

}
