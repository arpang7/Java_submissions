package lab.assignments;

import java.util.ArrayList;

/**
 * Food Delivery Application demonstrating:
 * 1. Member Inner Class - OrderDetails displays complete order information
 * 2. Anonymous Inner Classes - Handle delivery status updates at various stages
 */
public class FoodDelivery {

    // ---------- Outer class fields ----------
    private String restaurantName;
    private String customerName;
    private String orderId;
    private String deliveryAddress;
    private String orderStatus;
    private ArrayList<String> items;
    private double totalAmount;
    private String estimatedDeliveryTime;

    // ---------- Constructor ----------
    public FoodDelivery(String restaurantName, String customerName, String orderId,
                        String deliveryAddress, String estimatedDeliveryTime) {
        this.restaurantName = restaurantName;
        this.customerName = customerName;
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.orderStatus = "Order Pending";
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // ---------- Methods ----------
    /**
     * Adds an item to the order.
     * @param item Name of the menu item
     * @param price Price of the item
     */
    public void addItem(String item, double price) {
        items.add(item);
        totalAmount += price;
        System.out.println("   [Added] " + item + " - $" + String.format("%.2f", price));
    }

    /**
     * Updates the current order status.
     * @param status New status string
     */
    public void updateOrderStatus(String status) {
        this.orderStatus = status;
    }

    // ============================================================
    // 1. MEMBER INNER CLASS - OrderDetails
    // ============================================================
    /**
     * Inner class that displays complete order information.
     * It has access to all private fields of the outer FoodDelivery class.
     */
    class OrderDetails {
        void displayOrderSummary() {
            System.out.println("======================================");
            System.out.println("         ORDER SUMMARY");
            System.out.println("======================================");
            System.out.println("Order ID      : " + orderId);
            System.out.println("Restaurant    : " + restaurantName);
            System.out.println("Customer      : " + customerName);
            System.out.println("Items Ordered :");
            if (items.isEmpty()) {
                System.out.println("   (No items added yet)");
            } else {
                for (int i = 0; i < items.size(); i++) {
                    System.out.println("   " + (i + 1) + ". " + items.get(i));
                }
            }
            System.out.println("Total Amount  : $" + String.format("%.2f", totalAmount));
            System.out.println("======================================");
        }

        void displayDeliveryInfo() {
            System.out.println("======================================");
            System.out.println("       DELIVERY INFORMATION");
            System.out.println("======================================");
            System.out.println("Delivery Address : " + deliveryAddress);
            System.out.println("Estimated Time   : " + estimatedDeliveryTime);
            System.out.println("Current Status   : " + orderStatus);
            System.out.println("======================================");
        }
    }

    // ============================================================
    // 2. INTERFACE - DeliveryStatusCallback
    // ============================================================
    /**
     * Callback interface for delivery status updates.
     * Implemented by anonymous inner classes to handle different
     * stages of the delivery lifecycle.
     */
    interface DeliveryStatusCallback {
        void onStatusUpdate(String newStatus, String message);
    }

    // ============================================================
    // 3. Method demonstrating ANONYMOUS INNER CLASSES
    // ============================================================
    /**
     * Simulates the complete delivery lifecycle using anonymous inner classes.
     * Each stage of delivery is handled by a separate anonymous class
     * implementing the DeliveryStatusCallback interface.
     */
    public void simulateDeliveryLifecycle() {
        System.out.println("\n========== DELIVERY LIFECYCLE ==========\n");

        // ------------- Stage 1: Order Confirmed -------------
        System.out.println(">>> Stage 1: Order Confirmation");
        DeliveryStatusCallback confirmedCallback = new DeliveryStatusCallback() {
            @Override
            public void onStatusUpdate(String newStatus, String message) {
                updateOrderStatus(newStatus);
                System.out.println("   [Anonymous] Status: " + orderStatus);
                System.out.println("   [Anonymous] Message: " + message);
                System.out.println("   [Anonymous] Your order has been received and is being processed.\n");
            }
        };
        confirmedCallback.onStatusUpdate("Order Confirmed",
            "Thank you for your order! Your food will be prepared shortly.");

        // ------------- Stage 2: Preparing Food -------------
        System.out.println(">>> Stage 2: Food Preparation");
        DeliveryStatusCallback preparingCallback = new DeliveryStatusCallback() {
            @Override
            public void onStatusUpdate(String newStatus, String message) {
                updateOrderStatus(newStatus);
                System.out.println("   [Anonymous] Status: " + orderStatus);
                System.out.println("   [Anonymous] Message: " + message);
                System.out.println("   [Anonymous] The chef is preparing your meal with fresh ingredients.\n");
            }
        };
        preparingCallback.onStatusUpdate("Preparing",
            "Your order is being prepared by our top chefs!");

        // ------------- Stage 3: Out for Delivery -------------
        System.out.println(">>> Stage 3: Out for Delivery");
        DeliveryStatusCallback outForDeliveryCallback = new DeliveryStatusCallback() {
            @Override
            public void onStatusUpdate(String newStatus, String message) {
                updateOrderStatus(newStatus);
                System.out.println("   [Anonymous] Status: " + orderStatus);
                System.out.println("   [Anonymous] Message: " + message);
                System.out.println("   [Anonymous] Your delivery partner is on the way to " + deliveryAddress + "\n");
            }
        };
        outForDeliveryCallback.onStatusUpdate("Out for Delivery",
            "Your delivery partner has picked up the order and is heading your way!");

        // ------------- Stage 4: Delivered -------------
        System.out.println(">>> Stage 4: Delivered");
        DeliveryStatusCallback deliveredCallback = new DeliveryStatusCallback() {
            @Override
            public void onStatusUpdate(String newStatus, String message) {
                updateOrderStatus(newStatus);
                System.out.println("   [Anonymous] Status: " + orderStatus);
                System.out.println("   [Anonymous] Message: " + message);
                System.out.println("   [Anonymous] Bon appétit! 🎉\n");
            }
        };
        deliveredCallback.onStatusUpdate("Delivered",
            "Your order has been delivered! Enjoy your meal!");

        System.out.println("==========================================\n");
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   FOOD DELIVERY APPLICATION");
        System.out.println("   Inner Class & Anonymous Class Demo");
        System.out.println("============================================\n");

        // Create a FoodDelivery instance
        FoodDelivery order = new FoodDelivery(
            "Pizza Paradise",
            "Arpan Gupta",
            "ORD-2024-001",
            "123, Main Street, New Delhi",
            "30-40 minutes"
        );

        // Add items to the order
        System.out.println("--- Adding Items to Order ---");
        order.addItem("Margherita Pizza", 12.99);
        order.addItem("Garlic Breadsticks", 4.99);
        order.addItem("Coke (500ml)", 2.50);
        System.out.println();

        // --- 1. Member Inner Class: Display Order Details ---
        System.out.println("1. MEMBER INNER CLASS (OrderDetails):");
        System.out.println("   Displays complete order and delivery information\n");

        // Instantiate the inner class using outer class instance
        FoodDelivery.OrderDetails details = order.new OrderDetails();
        details.displayOrderSummary();
        System.out.println();
        details.displayDeliveryInfo();

        System.out.println();

        // --- 2. Anonymous Inner Classes: Delivery Lifecycle ---
        System.out.println("2. ANONYMOUS INNER CLASSES:");
        System.out.println("   Each delivery stage uses a separate anonymous class\n");

        order.simulateDeliveryLifecycle();

        // --- Final status check ---
        System.out.println("--- Final Order Status ---");
        details.displayDeliveryInfo();

        System.out.println("\n============================================");
        System.out.println("   END OF FOOD DELIVERY DEMO");
        System.out.println("============================================");
    }
}