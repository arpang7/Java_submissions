package lab.assignments;

import java.util.UUID;

// =====================================
// Abstract FoodOrder Base Class
// =====================================
abstract class FoodOrder {
    protected String orderId;
    protected String customerName;
    protected String items;
    protected double baseAmount;

    public FoodOrder(String customerName, String items, double baseAmount) {
        this.orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        this.customerName = customerName;
        this.items = items;
        this.baseAmount = baseAmount;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateBill();

    // Concrete method to display order details
    public void displayBill() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Items: " + items);
        System.out.println("Base Amount: $" + String.format("%.2f", baseAmount));
        System.out.println("Final Bill: $" + String.format("%.2f", calculateBill()));
    }
}

// =====================================
// Dine-In Order (adds service charge)
// =====================================
class DineInOrder extends FoodOrder {
    private int tableNumber;
    private double serviceChargePercent;

    public DineInOrder(String customerName, String items, double baseAmount,
                       int tableNumber, double serviceChargePercent) {
        super(customerName, items, baseAmount);
        this.tableNumber = tableNumber;
        this.serviceChargePercent = serviceChargePercent;
    }

    @Override
    public double calculateBill() {
        return baseAmount + (baseAmount * serviceChargePercent / 100);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public double getServiceChargePercent() {
        return serviceChargePercent;
    }

    @Override
    public void displayBill() {
        System.out.println("=== DINE-IN ORDER ===");
        System.out.println("Table Number: " + tableNumber);
        super.displayBill();
        double serviceCharge = baseAmount * serviceChargePercent / 100;
        System.out.println("Service Charge (" + serviceChargePercent + "%): $" + String.format("%.2f", serviceCharge));
        System.out.println("-----------------------------");
    }
}

// =====================================
// Take-Away Order (adds packaging, applies discount)
// =====================================
class TakeAwayOrder extends FoodOrder {
    private double packagingCharge;
    private double discountPercent;

    public TakeAwayOrder(String customerName, String items, double baseAmount,
                         double packagingCharge, double discountPercent) {
        super(customerName, items, baseAmount);
        this.packagingCharge = packagingCharge;
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateBill() {
        double discount = baseAmount * discountPercent / 100;
        return baseAmount + packagingCharge - discount;
    }

    public double getPackagingCharge() {
        return packagingCharge;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public void displayBill() {
        System.out.println("=== TAKE-AWAY ORDER ===");
        super.displayBill();
        double discount = baseAmount * discountPercent / 100;
        System.out.println("Packaging Charge: $" + String.format("%.2f", packagingCharge));
        System.out.println("Discount (" + discountPercent + "%): -$" + String.format("%.2f", discount));
        System.out.println("-----------------------------");
    }
}

// =====================================
// Main Application
// =====================================
public class FoodOrderSystem {
    public static void main(String[] args) {
        System.out.println("========== FOOD ORDER BILLING SYSTEM ==========");
        System.out.println("Demonstrating Abstract Class with DineIn & TakeAway Orders\n");

        // Create order instances using base class reference (polymorphism)
        FoodOrder dineIn = new DineInOrder("Arpan Gupta", "Pizza, Pasta, Garlic Bread", 45.00, 5, 10.0);
        FoodOrder takeAway = new TakeAwayOrder("Priya Sharma", "Burger, Fries, Milkshake", 28.50, 3.50, 5.0);

        // Store in array to demonstrate polymorphic behavior
        FoodOrder[] orders = {dineIn, takeAway};

        // Display all orders
        for (FoodOrder order : orders) {
            order.displayBill();
            System.out.println();
        }

        // Subclass-specific operations
        System.out.println("===== SUBCLASS-SPECIFIC OPERATIONS =====");

        DineInOrder dineInSpecific = (DineInOrder) dineIn;
        System.out.println("Dine-In - Table: " + dineInSpecific.getTableNumber()
                + ", Service Charge: " + dineInSpecific.getServiceChargePercent() + "%");

        TakeAwayOrder takeAwaySpecific = (TakeAwayOrder) takeAway;
        System.out.println("Take-Away - Packaging: $" + String.format("%.2f", takeAwaySpecific.getPackagingCharge())
                + ", Discount: " + takeAwaySpecific.getDiscountPercent() + "%");

        System.out.println("\n========== SYSTEM DEMONSTRATED SUCCESSFULLY ==========");
        System.out.println("Abstract Class: FoodOrder (abstract calculateBill())");
        System.out.println("Inheritance: DineInOrder, TakeAwayOrder -> FoodOrder");
        System.out.println("Polymorphism: All stored as FoodOrder references");
    }
}