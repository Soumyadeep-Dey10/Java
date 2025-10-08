package com.firstproj.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		
//SpringApplication.run(FirstProjectApplication.class, args) this interface extends applicationContext Interface
		
		ApplicationContext context =  SpringApplication.run(FirstProjectApplication.class, args);
		
		Student ob = context.getBean(Student.class); //this mentions that we dont need to create an object, but spring will create one for us
		ob.code();
	}

}
