package com.comb.spring.extension.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(id="firstListener", topics="first_topic")
	public void listener(String data){
		System.out.println("---------get data: " + data);
	}
}
