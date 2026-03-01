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
}