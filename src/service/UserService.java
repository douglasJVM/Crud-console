package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void listUsers() {
        for (User user : users) {
            user.displayUser();
            System.out.println("-------------");
        }
    }
    public User findUserById(Long id){
        for (User user : users){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public boolean deleteUserById(Long id){
        for (User user : users){
            if(user.getId().equals(id)){
                users.remove(user);
                return true;
            }
        }
        return false;
    }
    public boolean updateUser(Long id, String newName, String newEmail) {
        User user = findUserById(id);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }
}