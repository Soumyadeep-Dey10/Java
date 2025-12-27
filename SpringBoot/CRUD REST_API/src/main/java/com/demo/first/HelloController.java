package com.demo.first;
import com.demo.first.App.User;

import org.springframework.web.bind.annotation.*;


@RestController


@RequestMapping("/api") //url will be /api/user
public class HelloController {
    @GetMapping("/hello") //get request for hello endpoint
    public String sayHello(){
        return "Hello world";
    }

    //***Spring Boot automatically converts java objects into Json resp using jackson library
    @GetMapping("/user")

//    @RequestMapping(value = "/user",method = RequestMethod.GET) //alternate to getmapping but it is both class level and method level annotation
    public User getUser(){
        return new User(1,"Rup", "abc@gmail.com");
    }

}
