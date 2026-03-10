package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public boolean addUser(User user) {

        if (findUserById(user.getId()) != null) {
            return false;
        }

        users.add(user);
        return true;
    }

    public void listUsers() {

        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

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

    public boolean deleteUserById(Long id) {
        User user = findUserById(id);
        if (user != null) {
            users.remove(user);
            return true;
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