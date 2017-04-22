package com.dante.biz.jms.service;

public interface IQueueSenderService {
	void send(String queueName,final String message);
}
