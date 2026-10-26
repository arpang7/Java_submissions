package lab.assignments;

// =====================================
// Product Interface
// =====================================
interface ProductInterface {
    String getProductId();
    String getProductName();
    double getPrice();
    String getDescription();
    String getCategory();
    void displayProductDetails();
}

// =====================================
// Abstract Product Base Class
// =====================================
abstract class Product implements ProductInterface {
    protected String productId;
    protected String productName;
    protected double price;
    protected String description;
    protected String category;

    public Product(String productId, String productName, double price, String description, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    @Override
    public String getProductId() { return productId; }

    @Override
    public String getProductName() { return productName; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getDescription() { return description; }

    @Override
    public String getCategory() { return category; }

    @Override
    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
    }
}

// =====================================
// Electronic Product
// =====================================
class Electronic extends Product {
    private int warrantyPeriod;
    private String brand;

    public Electronic(String productId, String productName, double price, String description,
                      int warrantyPeriod, String brand) {
        super(productId, productName, price, description, "Electronics");
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }
    public String getBrand() { return brand; }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyPeriod + " months");
        System.out.println("-----------------------------");
    }
}

// =====================================
// Clothing Product
// =====================================
class Clothing extends Product {
    private String size;
    private String material;
    private String color;

    public Clothing(String productId, String productName, double price, String description,
                    String size, String material, String color) {
        super(productId, productName, price, description, "Clothing");
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public String getSize() { return size; }
    public String getMaterial() { return material; }
    public String getColor() { return color; }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
        System.out.println("-----------------------------");
    }
}

// =====================================
// Grocery Product
// =====================================
class Grocery extends Product {
    private String expiryDate;
    private double weight;
    private boolean isPerishable;

    public Grocery(String productId, String productName, double price, String description,
                   String expiryDate, double weight, boolean isPerishable) {
        super(productId, productName, price, description, "Groceries");
        this.expiryDate = expiryDate;
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    public String getExpiryDate() { return expiryDate; }
    public double getWeight() { return weight; }
    public boolean isPerishable() { return isPerishable; }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Perishable: " + (isPerishable ? "Yes" : "No"));
        System.out.println("-----------------------------");
    }
}

// =====================================
// Main Application
// =====================================
public class ECommerceApp {
    public static void main(String[] args) {
        System.out.println("========== E-COMMERCE PRODUCT SYSTEM ==========");
        System.out.println("Demonstrating Inheritance, Interfaces, and Polymorphism\n");

        // Creating product instances using interface reference (polymorphism)
        ProductInterface laptop = new Electronic("E1001", "Gaming Laptop", 1299.99,
                "High-performance laptop with RTX 4070 GPU", 24, "TechPro");

        ProductInterface tshirt = new Clothing("C2001", "Cotton T-Shirt", 29.99,
                "Premium quality casual t-shirt", "L", "Cotton", "Navy Blue");

        ProductInterface apple = new Grocery("G3001", "Organic Apples", 4.99,
                "Fresh organic apples from local farm", "2025-04-15", 1.5, true);

        // Storing in array to demonstrate polymorphic behavior
        ProductInterface[] products = {laptop, tshirt, apple};

        // Display all products using interface reference
        for (ProductInterface product : products) {
            product.displayProductDetails();
        }

        // Accessing subclass-specific methods through casting
        System.out.println("\n===== SUBCLASS-SPECIFIC OPERATIONS =====");

        Electronic electronicProduct = (Electronic) laptop;
        System.out.println("Electronic - Brand: " + electronicProduct.getBrand()
                + ", Warranty: " + electronicProduct.getWarrantyPeriod() + " months");

        Clothing clothingProduct = (Clothing) tshirt;
        System.out.println("Clothing - Size: " + clothingProduct.getSize()
                + ", Material: " + clothingProduct.getMaterial()
                + ", Color: " + clothingProduct.getColor());

        Grocery groceryProduct = (Grocery) apple;
        System.out.println("Grocery - Expires: " + groceryProduct.getExpiryDate()
                + ", Weight: " + groceryProduct.getWeight() + " kg"
                + ", Perishable: " + (groceryProduct.isPerishable() ? "Yes" : "No"));

        System.out.println("\n========== SYSTEM DEMONSTRATED SUCCESSFULLY ==========");
        System.out.println("Inheritance: Electronic, Clothing, Grocery -> Product");
        System.out.println("Interface: Product implements ProductInterface");
        System.out.println("Polymorphism: All stored as ProductInterface references");
    }
}