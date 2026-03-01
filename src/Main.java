import model.User;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        User user1 = new User(1L, "Teste1", "Teste1@email.com");
        User user2 = new User(2L, "Teste2", "Teste2@email.com");

        service.addUser(user1);
        service.addUser(user2);

        service.listUsers();
    }
}