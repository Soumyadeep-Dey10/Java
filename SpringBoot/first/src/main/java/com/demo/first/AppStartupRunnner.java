package com.demo.first;

//will run automatically when springboot application starts

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunnner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DB initialisation using appstartuprunner");
    }
}
