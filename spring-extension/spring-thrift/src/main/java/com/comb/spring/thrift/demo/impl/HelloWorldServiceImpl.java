package com.comb.spring.thrift.demo.impl;
import org.apache.thrift.TException;

import com.comb.spring.thrift.demo.*;

public class HelloWorldServiceImpl implements HelloWorldService.Iface{

	@Override
	public String sayHello(String username) throws TException {
		System.out.println("方法被调用...........");
		return username;
	}

}
