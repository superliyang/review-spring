package com.comb.spring.core.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.comb.spring.core.domain.Queue;

/**
 * 运行时获取ApplicationContext对象，从而动态的操作bean
 * 用于动态注册bean
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */

@Component
public class ApplicationContextAwareUse implements ApplicationContextAware{
	
	protected ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

	public void registerBean(Object obj){
		//构建beanDefinition，然后调用注册。
		Class clazz = obj.getClass();
		BeanDefinition bean = BeanDefinitionBuilder.genericBeanDefinition(clazz).getRawBeanDefinition();
		registerBean(clazz.getName(), bean);
	}
	
	private void registerBean(String beanName, BeanDefinition beanDefinition){
		ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getBeanFactory();
		factory.registerBeanDefinition(beanName, beanDefinition);
		
		System.out.println("---------------"+((Queue)factory.getBean(beanName)).default_name);
	}
}
