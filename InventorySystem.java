import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventorySystem {
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private User loggedInUser = null;

    public InventorySystem() {
        // Prepopulate with one admin user
        users.add(new User("admin", "admin123", true));
    }

    // Register a new user
    public void registerUser(String username, String password, boolean isAdmin) {
        users.add(new User(username, password, isAdmin));
        System.out.println("User registered successfully.");
    }

    // Login a user
    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    // Add a new product
    public void addProduct(String name, double price) {
        if (loggedInUser != null && loggedInUser.isAdmin()) {
            products.add(new Product(name, price));
            System.out.println("Product added: " + name + " - $" + price);
        } else {
            System.out.println("You need to be an admin to add products.");
        }
    }

    // View all products
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
    }

    // Get the current logged-in user
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
