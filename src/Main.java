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

        User foundUser = service.findUserById(1L);

        if(foundUser !=null){
            System.out.println("User found: ");
            foundUser.displayUser();
        } else {
            System.out.println("User not found.");
        }

        boolean deleted = service.deleteUserById(2L);

        if (deleted) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found.");
        }

        System.out.println("Updated list:");
        service.listUsers();

    }
}