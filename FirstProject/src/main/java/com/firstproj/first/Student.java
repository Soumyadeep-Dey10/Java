package com.firstproj.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired //this mentions that we dont need to create an object, but spring will create one for us
	Laptop lap;
	public void code() {
		lap.compile();
	}
}
