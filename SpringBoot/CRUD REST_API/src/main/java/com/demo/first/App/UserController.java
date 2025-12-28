package com.demo.first.App;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final HashMap<Integer, User> map = new HashMap<>();

    // CREATE
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        map.putIfAbsent(user.getId(), user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable int id,
            @RequestBody User user
    ) {
        if (!map.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        map.put(id, user);
        return ResponseEntity.ok(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if (!map.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        map.remove(id);
        return ResponseEntity.noContent().build();
    }

    // READ
    @GetMapping
    public List<User> getUsers() {
        return new ArrayList<>(map.values());
    }


    //READ by individual id
    //required = false, for optional parameters

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable (value = "userId", required = false) int id){
        if(!map.containsKey(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(map.get(id));
    }

//@GetMapping({"/users","/user/{id}"}) //alternate to map both url


    //Find orders by particular user and orderid
    @GetMapping("{userId}/order/{orderId}")
    public ResponseEntity<User> getUserOrder(@PathVariable("userId")int id, @PathVariable int orderId){
        if(!map.containsKey(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(map.get(id));
    }


    //search api
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(required = false) String name){
        System.out.println(name);
        List<User> users = map.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .toList();
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/info/{id}")
    public String getInfo(@PathVariable int id,
                          @RequestParam String name,
                          @RequestHeader("User-Agent") String userAgent){
        return id+" "+name+ " "+userAgent;
    }
}
