package lab.assignments;

/**
 * Vehicle program demonstrating:
 * 1. Member Inner Class - VehicleDetails displays vehicle details
 * 2. Anonymous Inner Class - performs an action
 */
public class Vehicle {

    // ---------- Outer class fields ----------
    private String brand;
    private String model;
    private int year;
    private int speed;
    private String engineType;

    // ---------- Constructor ----------
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0;
        this.engineType = engineType;
    }

    // ---------- Getter methods ----------
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    public String getEngineType() {
        return engineType;
    }

    // ============================================================
    // 1. MEMBER INNER CLASS - VehicleDetails
    // ============================================================
    /**
     * Inner class that displays all vehicle details.
     * It has access to private fields of the outer Vehicle class.
     */
    public class VehicleDetails {
        public void display() {
            System.out.println("===== VEHICLE DETAILS =====");
            System.out.println("Brand      : " + brand);
            System.out.println("Model      : " + model);
            System.out.println("Year       : " + year);
            System.out.println("Engine     : " + engineType);
            System.out.println("Speed      : " + speed + " km/h");
            System.out.println("============================");
        }
    }

    // ============================================================
    // 2. ANONYMOUS INNER CLASS - performs an action
    // ============================================================
    /**
     * Interface for vehicle actions.
     */
    interface VehicleAction {
        void performAction();
    }

    /**
     * Demonstrates the use of an anonymous inner class.
     * An anonymous class implements the VehicleAction interface
     * and overrides performAction() on the fly.
     */
    public void demonstrateAction() {
        // Anonymous inner class implementing VehicleAction
        VehicleAction action = new VehicleAction() {
            @Override
            public void performAction() {
                System.out.println(">> [Anonymous Inner Class] Action: Vehicle is accelerating!");
                System.out.println(">> [Anonymous Inner Class] Current speed: " + speed + " km/h");
                System.out.println(">> [Anonymous Inner Class] Engine (" + engineType + ") roars to life!");
                System.out.println(">> [Anonymous Inner Class] Vroom! Vroom!");
            }
        };

        action.performAction();
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   VEHICLE PROGRAM - INNER CLASS DEMO");
        System.out.println("========================================\n");

        // Create a Vehicle instance
        Vehicle myVehicle = new Vehicle("Toyota", "Camry", 2024, "V6 Petrol");

        // --- 1. Member Inner Class: Display Vehicle Details ---
        System.out.println("1. MEMBER INNER CLASS (VehicleDetails):");
        System.out.println("   Displays all vehicle information\n");

        // Instantiate the inner class using outer class instance
        Vehicle.VehicleDetails details = myVehicle.new VehicleDetails();
        details.display();

        System.out.println();

        // --- 2. Anonymous Inner Class: Perform Action ---
        System.out.println("2. ANONYMOUS INNER CLASS:");
        System.out.println("   Performs an action by implementing VehicleAction interface\n");

        myVehicle.demonstrateAction();

        System.out.println();
        System.out.println("========================================");
        System.out.println("   END OF VEHICLE PROGRAM");
        System.out.println("========================================");
    }
}