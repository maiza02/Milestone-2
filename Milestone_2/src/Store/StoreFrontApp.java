package Store;
//Maiza Falcon Rojas
//CST-239
//02/09/2024
//This is my own code

import java.util.Scanner;


/**
 * The StoreFrontApp class represents the main application for managing the store.
 */
class StoreFrontApp {
    private String storeName;
    private InventoryManager inventoryManager;

    public StoreFrontApp(String storeName) {
        this.storeName = storeName;
        this.inventoryManager = new InventoryManager();
    }

    /**
     * Displays the welcome message for the store.
     */
    public void displayWelcome() {
        System.out.println("Welcome to " + storeName + "!");
    }

    
    /**
     * Displays the available actions for the user.
     */
    public void displayActions() {
        System.out.println("1. Display Inventory");
        System.out.println("2. Purchase Product");
        System.out.println("3. Cancel Purchase");
    }

    
    /**
     * Executes the selected action based on the user's choice.
     *
     * @param action The user's choice of action.
     */
    public void executeAction(int action) {
        switch (action) {
            case 1:
                displayInventory();
                break;
            case 2:
                purchaseOrCancel(true); // Purchase
                break;
            case 3:
                purchaseOrCancel(false); // Cancel
                break;
            default:
                System.out.println("Invalid action. Please choose a valid action.");
        }
    }

    
    /**
     * Displays the current inventory of salable products.
     */
    public void displayInventory() {
        System.out.println("Inventory:");
        for (SalableProduct product : inventoryManager.getInventory()) {
            System.out.println(product.name + " - " + product.description + " - $" + product.price + " - Quantity: " + product.quantity);
        }
    }

    
    /**
     * Handles the purchase or cancellation of a product based on user input.
     *
     * @param isPurchase True if it is a purchase, false for cancellation.
     */
    public void purchaseOrCancel(boolean isPurchase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product: ");
        String productName = scanner.nextLine();

        for (SalableProduct product : inventoryManager.getInventory()) {
            if (product.name.equalsIgnoreCase(productName)) {
                int quantity = readValidQuantity();
                if (isPurchase) {
                    inventoryManager.purchaseProduct(product, quantity);
                    
                } else {
                    inventoryManager.cancelPurchase(product, quantity);

                }
                return;
            }
        }

        System.out.println("Product not found in the inventory. Please enter a valid product name.");
    }

    
    /**
     * Reads a valid quantity input from the user.
     *
     * @return The valid quantity entered by the user.
     */
    private int readValidQuantity() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the quantity: ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    
    
    /**
     * Displays feedback messages to the user.
     *
     * @param message The feedback message to be displayed.
     */
    public void displayFeedback(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        StoreFrontApp storeApp = new StoreFrontApp("Maiza's Emporium of Goods");
        storeApp.displayWelcome();
        storeApp.inventoryManager.populateInventory();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            storeApp.displayActions();
            System.out.print("Choose an action (0 to exit): ");
            int userAction = scanner.nextInt();

            if (userAction == 0) {
                System.out.println("Exiting. Thank you for visiting " + storeApp.storeName + "!");
                break;
            }

            storeApp.executeAction(userAction);
            scanner.nextLine(); // Consume the newline character after reading the integer

            System.out.print("Do you want to choose another action? (yes/no): ");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!continueChoice.equals("yes")) {
                System.out.println("Exiting. Thank you for visiting " + storeApp.storeName + "!");
                break;
            }
        }
    }
}
