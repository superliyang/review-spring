package com.comb.spring.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class UseDisposableBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("实现DisposableBean接口来实现bean销毁之前做一些操作。");
	}

}
