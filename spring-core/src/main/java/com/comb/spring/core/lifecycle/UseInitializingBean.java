package com.comb.spring.core.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 
 * Spring官方已经不推荐这种方式来扩展Bean的初始化操作。
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */
@Component
public class UseInitializingBean implements InitializingBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("实现InitializingBean接口来完成初始化操作，跟@PostConstruct意义一样。");
	}
}
