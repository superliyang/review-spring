package com.comb.spring.core.test.lifecycle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.comb.spring.core.config.SpringCoreConfiguration;
import com.comb.spring.core.domain.Queue;
import com.comb.spring.core.extension.ApplicationContextAwareUse;

/**
 * Spring Bean生命周期扩展测试
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={SpringCoreConfiguration.class})
public class BeanLifeCycleTest {
	
	@Autowired
	private ApplicationContextAwareUse applicationContextAwareUse;
	
	@Before
	public void init(){
		applicationContextAwareUse.registerBean(new Queue());
	}

	@Test
	public void lifeCycleTest(){
		
	}
}
