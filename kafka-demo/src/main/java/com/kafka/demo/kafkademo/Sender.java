package com.kafka.demo.kafkademo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	private AtomicInteger count = new AtomicInteger();
	private final KafkaTemplate<String, String> template;
	public Sender(KafkaTemplate<String, String> template) {
		this.template = template;
	}
	
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		this.template.send("string-topic", "message:" + this.count.getAndIncrement());
	}

}
