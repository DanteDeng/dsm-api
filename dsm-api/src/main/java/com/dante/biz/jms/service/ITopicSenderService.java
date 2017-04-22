package com.dante.biz.jms.service;

public interface ITopicSenderService {
	void send(String topicName,final String message);
}
