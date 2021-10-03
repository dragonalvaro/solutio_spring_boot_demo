package com.example.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.twitter.listener.TwitterStreamingListener;

@SpringBootApplication
public class TwitterApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TwitterApplication.class, args);
		context.getBean(TwitterStreamingListener.class).streamFeed();
	}

}
