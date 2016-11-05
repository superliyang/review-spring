package com.comb.spring.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanOrder implements InitializingBean, DisposableBean{
	
	public void customInit(){
		System.out.println("***我是通过配置init-method来实现的初始化方法。");
	}
	
	public void customDestroy(){
		System.out.println("***我是通过配置destroy-method来实现的初始化方法。");
	}
	
	@PostConstruct
	public void initMethod(){
		System.out.println("***我是加了@PostConstruct注解的init方法。");
	}
	
	@PreDestroy
	public void destroyMethod(){
		System.out.println("***我是加了@PreDestroy注解的destroy方法。");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("***我是实现DisposableBean接口的destroy方法。");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("***我是实现InitializingBean接口的afterPropertiesSet方法。");
	}
	
}
