package com.ducat.beans;

import org.springframework.stereotype.Component;

@Component()
public interface ABC {

	public void a();
	public String b();
	public void c(int x) throws Exception;
}
