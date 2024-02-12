package Store;
//Maiza Falcon Rojas
//CST-239
//02/09/2024
//This is my own code

import java.util.ArrayList;
import java.util.List;

/**
 * The InventoryManager class manages the inventory of salable products in a store.
 */
class InventoryManager {
    private List<SalableProduct> inventory;

    /**
     * Constructs an InventoryManager with an empty inventory.
     */
    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    
    /**
     * Populates the initial inventory with hardcoded products.
     */
    public void populateInventory() {
        // Hardcode initial inventory
        Weapon weapon1 = new Weapon("Sword", "Sharp and deadly", 50.0, 10, 20, "Melee");
        Weapon weapon2 = new Weapon("Bow", "Great for ranged attacks", 40.0, 15, 15, "Ranged");
        Armor armor1 = new Armor("Plate Mail", "Heavy protection", 80.0, 5, 30, "Heavy");
        Armor armor2 = new Armor("Leather Armor", "Light and flexible", 30.0, 8, 15, "Light");
        Health health = new Health("Potion", "Restores health", 10.0, 20, "Healing");

        inventory.add(weapon1);
        inventory.add(weapon2);
        inventory.add(armor1);
        inventory.add(armor2);
        inventory.add(health);
    }

    
    /**
     * Handles the purchase of a specified quantity of a product.
     *
     * @param product  The product to be purchased.
     * @param quantity The quantity to be purchased.
     */
    public void purchaseProduct(SalableProduct product, int quantity) {
        for (SalableProduct inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                if (inventoryProduct.getQuantity() >= quantity) {
                    // Decrease the quantity of the product in the inventory
                    inventoryProduct.adjustQuantity(-quantity);
                    System.out.println("Purchase successful! Thank you for buying " + quantity + " " + product.getName() + ".");
                } else {
                    System.out.println("Not enough quantity available for " + product.getName() + ".");
                }
                return;
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
    }


    
    
    /**
     * Cancels a previous purchase and adjusts the inventory accordingly.
     *
     * @param product  The product for which the purchase is canceled.
     * @param quantity The quantity to be canceled.
     */
    public void cancelPurchase(SalableProduct product, int quantity) {
        for (SalableProduct inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                // Increase the quantity of the product in the inventory
                inventoryProduct.adjustQuantity(quantity);
                System.out.println("Purchase canceled for " + quantity + " " + product.getName() + ".");
                return;
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
    }
    
    
    /**
     * Retrieves the current inventory of salable products.
     *
     * @return The list of salable products in the inventory.
     */
    public List<SalableProduct> getInventory() {
        return this.inventory;
    }
}


