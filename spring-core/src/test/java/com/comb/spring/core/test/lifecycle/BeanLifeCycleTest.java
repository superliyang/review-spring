package com.comb.spring.core.test.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.comb.spring.core.config.SpringCoreConfiguration;

/**
 * Spring Bean生命周期扩展测试
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={SpringCoreConfiguration.class})
public class BeanLifeCycleTest {

	@Test
	public void lifeCycleTest(){
		
	}
}
