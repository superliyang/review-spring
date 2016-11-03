package com.comb.spring.core.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Spring在内部使用 BeanPostProcessor 实现来处理它能找到的任何回调接口并调用相应的方法。如果你需要自定义特性或者生命周期行为，你可以实现自己的 BeanPostProcessor
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */
@Component
public class UseBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 在Bean初始化方法（@PostConstruct注解的方法，init-method指定的方法，还有实现了InitializingBean接口的方法）调用之后做一些处理
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(">>调用完了"+beanName+"初始化方法.");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof BeanLifeCycleExample){
			((BeanLifeCycleExample)bean).postProcessBeforeInitializationTest();
		}
		System.out.println(">>调用"+beanName+"初始化方法之前，我要在这里做什么处理，比如拦截到某个指定的bean，然后做一些处理");
		return bean;
	}

}
