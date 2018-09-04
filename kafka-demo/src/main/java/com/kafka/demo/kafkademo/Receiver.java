 package com.kafka.demo.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	 
	 @KafkaListener(topics = "string-topic", groupId ="group_id")
	 public void consume(String message) {
		 System.out.println("Received: " + message);
	 }

}
