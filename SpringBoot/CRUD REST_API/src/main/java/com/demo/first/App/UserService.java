import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService(){
    private final HashMap<Integer, User> map = new HashMap<>();

    public User createUser(User user){
        System.out.println(user.getEmail());
        map.putIfAbsent(user.getId(), user);
        return user;
    }
    public User updateUser(User user){
        if (!map.containsKey(user.getId())) {
            throw new IllegalAccessException("User with ID"+user.getId());
        }
        map.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int id){
        if(!map.containsKey(id))
            return false;
        map.remove(id);
        return true;
    }
    public List<User> getAllUsers(){
        return new ArrayList<>(map.values());
    }
    public User getUserById(int id){
        if(!map.containsKey(id))
            return null;
        return map.get(id);
    }

    public User searchUsers(String name){
        return map.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .toList();
    }
}