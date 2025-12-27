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
}
