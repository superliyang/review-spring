package com.comb.spring.extension.kafka.producer;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	private final String topic = "test";
	
	@PostConstruct
	public void init(){
		//如果设置了default则需要调用sendDefault()
//		kafkaTemplate.setDefaultTopic("test");
	}
	
	public void sendMessage(String message){
		try {
			System.out.println("发送消息。。。。");
			ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);
			future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

				@Override
				public void onSuccess(SendResult<Integer, String> result) {
					System.out.println("发送消息成功。");
					System.out.println(result.getProducerRecord().topic());
					System.out.println(result.getProducerRecord().key());
					System.out.println(result.getProducerRecord().value());
				}

				@Override
				public void onFailure(Throwable trhowable) {
					System.out.println("发送消息失败，异常：");
					
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
