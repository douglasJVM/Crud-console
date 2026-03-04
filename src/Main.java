import model.User;
import service.UserService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserService service = new UserService();
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n==== USER MANAGEMENT SYSTEM ====");
            System.out.println("1 - Add User");
            System.out.println("2 - List Users");
            System.out.println("3 - Find User by ID");
            System.out.println("4 - Delete User");
            System.out.println("5 - Update User");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Enter ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    service.addUser(new User(id, name, email));
                    System.out.println("User added successfully!");
                    break;

                case 2:
                    service.listUsers();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    Long searchId = scanner.nextLong();
                    scanner.nextLine();

                    User found = service.findUserById(searchId);
                    if (found != null) {
                        found.displayUser();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    Long deleteId = scanner.nextLong();
                    scanner.nextLine();

                    boolean deleted = service.deleteUserById(deleteId);
                    if (deleted) {
                        System.out.println("User deleted successfully!");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.println("Enter user ID to update:");
                    Long updateId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();

                    System.out.println("Enter new email:");
                    String newEmail = scanner.nextLine();

                    boolean updated = service.updateUser(updateId, newName, newEmail);
                    if (updated) {
                        System.out.println("User updated successfully!");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();

    }
}