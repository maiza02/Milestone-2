package Store;
//Maiza Falcon Rojas
//CST-239
//02/09/2024
//This is my own code

/**
 * The SalableProduct class represents a product that can be sold in the store.
 */
class SalableProduct {
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;
    
    
    /**
     * Constructs a SalableProduct with the specified attributes.
     *
     * @param name        The name of the product.
     * @param description A brief description of the product.
     * @param price       The price of the product.
     * @param quantity    The initial quantity of the product in the inventory.
     */
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    
    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    
    /**
     * Retrieves the current quantity of the product in the inventory.
     *
     * @return The quantity of the product in the inventory.
     */
    public int getQuantity() {
        return quantity;
    }

    
    /**
     * Adjusts the quantity of the product by the specified delta.
     *
     * @param quantityDelta The change in quantity (positive or negative).
     */
    // Instead of a setQuantity method, we can provide a method to adjust the quantity
    public void adjustQuantity(int quantityDelta) {
        this.quantity += quantityDelta;
    }
    
}