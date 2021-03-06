package com.comb.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

import com.comb.spring.core.lifecycle.BeanOrder;
import com.comb.spring.core.lifecycle.CommonBean;

/**
 * 扫描整个core包，但是不要在扫描所有的配置类了，配置类单独加载。
 * @author Xiaoyang.Li
 *
 * https://github.com/superliyang
 */
@Configuration
@ComponentScan(basePackages={"com.comb.spring.core"}, excludeFilters={@Filter(type=FilterType.REGEX ,pattern="com.comb.spring.core.*.*Configuration")})
public class SpringCoreConfiguration {
	
	@Bean(initMethod="customInit")
	public CommonBean commonBean(){
		return new CommonBean();
	}
	
	@Bean(initMethod="customInit", destroyMethod="customDestroy")
	public BeanOrder beanOrder(){
		return new BeanOrder();
	}

}
