import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventorySystem inventorySystem = new InventorySystem();

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Products");
            System.out.println("4. Add Product (Admin Only)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    System.out.print("Is admin (true/false): ");
                    boolean isAdmin = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    inventorySystem.registerUser(registerUsername, registerPassword, isAdmin);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    if (inventorySystem.login(loginUsername, loginPassword)) {
                        // Do nothing, just log in
                    }
                    break;

                case 3:
                    inventorySystem.viewProducts();
                    break;

                case 4:
                    if (inventorySystem.getLoggedInUser() != null && inventorySystem.getLoggedInUser().isAdmin()) {
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double productPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        inventorySystem.addProduct(productName, productPrice);
                    } else {
                        System.out.println("You must be logged in as an admin to add products.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
