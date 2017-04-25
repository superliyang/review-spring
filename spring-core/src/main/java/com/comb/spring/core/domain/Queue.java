package com.comb.spring.core.domain;

public class Queue {

	private String name;
	private int len;
	
	public String default_name = "liyang";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}
}
