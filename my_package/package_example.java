package lab.my_package;

import lab.assignments.Vehicle;

public class package_example {
    public static void main(String args[]) {
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