package com.comb.spring.extension.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comb.spring.extension.kafka.config.KafKaConfiguration;
import com.comb.spring.extension.kafka.producer.KafkaProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=KafKaConfiguration.class)
public class KafkaTest {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Test
	public void testSend() throws InterruptedException{
		for(int i=0; i<1000; i++){
			kafkaProducer.sendMessage("*********************kafka message _ " + i);
			Thread.sleep(1000);
		}
	}
}
