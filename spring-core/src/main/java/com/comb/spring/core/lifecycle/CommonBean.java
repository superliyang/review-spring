package com.comb.spring.core.lifecycle;

public class CommonBean {

	public void customInit(){
		System.out.println("我是通过配置init-method来实现的初始化方法。");
	}
}
