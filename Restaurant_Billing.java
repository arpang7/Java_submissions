package lab.practice;

public class Restaurant_Billing {

    // Static variable to track total orders
    static int total_orders = 0;

    // Dine-in order (5% service charge)
    void calculate_bill(double amount) {
        total_orders++;
        double bill = amount + (amount * 0.05);
        System.out.println("Dine-in Bill = ₹" + bill);
    }

    // Takeaway order (no extra charge)
    void calculate_bill(double amount, boolean takeaway) {
        total_orders++;
        System.out.println("Takeaway Bill = ₹" + amount);
    }

    // Delivery order (fixed delivery charge)
    void calculate_bill(double amount, double deliveryCharge) {
        total_orders++;
        double bill = amount + deliveryCharge;
        System.out.println("Delivery Bill = ₹" + bill);
    }

    public static void main(String[] args) {

        Restaurant_Billing order = new Restaurant_Billing();

        // Dine-in
        order.calculate_bill(800);

        // Takeaway
        order.calculate_bill(500, true);

        // Delivery
        order.calculate_bill(700, 50);

        // Display total orders
        System.out.println("Total Orders = " + total_orders);
    }
}