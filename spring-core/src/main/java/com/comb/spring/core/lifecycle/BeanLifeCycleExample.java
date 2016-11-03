package com.comb.spring.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * 生命周期回调（Bean lifecycle callback）
 * Bean的生命周期扩展是很重要的，首先要知道，bean在生命周期有哪些地方可以自定义扩展。
 * Bean通过@PostConstruct和@PreDestroy来扩展生命周期内的操作。
 * 关于使用构造器和初始化方法的分析：如果只是简单的对象初始化，我们可以将其放到构造器中处理；如果是对注入的类或者帮助类做一些初始化处理，可以考虑使用初始化方法。
 * @author Xiaoyang.Li (https://github.com/superliyang)
 *
 */
@Component
public class BeanLifeCycleExample {
	
	public BeanLifeCycleExample(){
		System.out.println("初始化构造器");
	}
	
	@PostConstruct
	public void initMethod(){
		//该方式跟在xml中bean标签上设置init-method是一样的。
		//<bean id="exampleInitBean" class="examples.ExampleBean" init-method="init"/>
		System.out.println("@PostConstruct允许容器bean创建并设置好所有必要属性之后，做出一些初始化处理");
	}
	
	@PreDestroy
	public void destroyMethod(){
		//该方式跟在xml中bean标签上设置destroy-method是一样的。
		//<bean id="exampleInitBean" class="examples.ExampleBean" destroy-method="cleanup"/>
		System.out.println("@PreDestroy允许在bean销毁之前做出一些处理");
	}
	
	public void postProcessBeforeInitializationTest(){
		System.out.println("在bean实例化完成，调用初始化方法之前，来调用我吧。");
	}
	
}
