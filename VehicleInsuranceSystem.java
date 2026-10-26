package lab.assignments;

/**
 * Vehicle Insurance System demonstrating the super keyword:
 * 1. super() - to call parent class constructor
 * 2. super.methodName() - to call parent class overridden method
 * 3. super.fieldName - to access parent class fields directly
 */

// ============================================================
// PARENT CLASS: InsuredVehicle
// ============================================================
class InsuredVehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    protected String ownerName;

    // Parameterized constructor
    public InsuredVehicle(String brand, String model, int year, double price, String ownerName) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.ownerName = ownerName;
    }

    // Display vehicle information
    public void displayVehicleInfo() {
        System.out.println("=== Insured Vehicle Details ===");
        System.out.println("Brand      : " + brand);
        System.out.println("Model      : " + model);
        System.out.println("Year       : " + year);
        System.out.println("Price      : $" + price);
        System.out.println("Owner      : " + ownerName);
    }

    // Calculate base insured value (80% of the price)
    public double calculateInsuredValue() {
        return price * 0.80;
    }
}

// ============================================================
// CHILD CLASS 1: CarInsurance
// ============================================================
class CarInsurance extends InsuredVehicle {
    private String coverageType; // Comprehensive, ThirdParty, Collision
    private int numDoors;

    // Constructor using super() to call parent constructor
    public CarInsurance(String brand, String model, int year, double price, 
                        String ownerName, String coverageType, int numDoors) {
        super(brand, model, year, price, ownerName); // calling InsuredVehicle constructor
        this.coverageType = coverageType;
        this.numDoors = numDoors;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // calling parent's displayVehicleInfo()
        System.out.println("--- Car Insurance Specifics ---");
        System.out.println("Coverage   : " + coverageType);
        System.out.println("Doors      : " + numDoors);
        System.out.println("================================");
    }

    @Override
    public double calculateInsuredValue() {
        // Using super to get base insured value and adding car-specific adjustments
        double baseValue = super.calculateInsuredValue();
        double coverageMultiplier;
        switch (coverageType.toLowerCase()) {
            case "comprehensive":
                coverageMultiplier = 1.2; // 20% extra for comprehensive
                break;
            case "collision":
                coverageMultiplier = 1.1; // 10% extra for collision
                break;
            default:
                coverageMultiplier = 0.9; // 10% less for third party
                break;
        }
        return baseValue * coverageMultiplier;
    }

    // Method to demonstrate accessing parent fields using super
    public void showParentFields() {
        System.out.println("=== Accessing Parent Fields via super ===");
        System.out.println("super.brand      : " + super.brand);
        System.out.println("super.model      : " + super.model);
        System.out.println("super.year       : " + super.year);
        System.out.println("super.price      : $" + super.price);
        System.out.println("super.ownerName  : " + super.ownerName);
        System.out.println("=========================================");
    }
}

// ============================================================
// CHILD CLASS 2: BikeInsurance
// ============================================================
class BikeInsurance extends InsuredVehicle {
    private boolean helmetCoverage;
    private boolean hasSideCar;

    // Constructor using super() to call parent constructor
    public BikeInsurance(String brand, String model, int year, double price, 
                         String ownerName, boolean helmetCoverage, boolean hasSideCar) {
        super(brand, model, year, price, ownerName); // calling InsuredVehicle constructor
        this.helmetCoverage = helmetCoverage;
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // calling parent's displayVehicleInfo()
        System.out.println("--- Bike Insurance Specifics ---");
        System.out.println("Helmet Coverage : " + (helmetCoverage ? "Yes" : "No"));
        System.out.println("Side Car        : " + (hasSideCar ? "Yes" : "No"));
        System.out.println("================================");
    }

    @Override
    public double calculateInsuredValue() {
        // Using super to get base insured value and adding bike-specific adjustments
        double baseValue = super.calculateInsuredValue();
        if (helmetCoverage) {
            baseValue += 200; // Additional $200 for helmet coverage
        }
        if (hasSideCar) {
            baseValue += baseValue * 0.15; // 15% extra for side car
        }
        return baseValue;
    }

    // Method to demonstrate accessing parent fields using super
    public void showParentFields() {
        System.out.println("=== Accessing Parent Fields via super ===");
        System.out.println("super.brand      : " + super.brand);
        System.out.println("super.model      : " + super.model);
        System.out.println("super.year       : " + super.year);
        System.out.println("super.price      : $" + super.price);
        System.out.println("super.ownerName  : " + super.ownerName);
        System.out.println("=========================================");
    }
}

// ============================================================
// CHILD CLASS 3: TruckInsurance
// ============================================================
class TruckInsurance extends InsuredVehicle {
    private boolean cargoCoverage;
    private double loadCapacity; // in tons

    // Constructor using super() to call parent constructor
    public TruckInsurance(String brand, String model, int year, double price, 
                          String ownerName, boolean cargoCoverage, double loadCapacity) {
        super(brand, model, year, price, ownerName); // calling InsuredVehicle constructor
        this.cargoCoverage = cargoCoverage;
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // calling parent's displayVehicleInfo()
        System.out.println("--- Truck Insurance Specifics ---");
        System.out.println("Cargo Coverage : " + (cargoCoverage ? "Yes" : "No"));
        System.out.println("Load Capacity  : " + loadCapacity + " tons");
        System.out.println("================================");
    }

    @Override
    public double calculateInsuredValue() {
        // Using super to get base insured value and adding truck-specific adjustments
        double baseValue = super.calculateInsuredValue();
        if (cargoCoverage) {
            baseValue += baseValue * 0.25; // 25% extra for cargo coverage
        }
        // Trucks with higher load capacity have higher insured value
        baseValue += loadCapacity * 500; // $500 per ton
        return baseValue;
    }

    // Method to demonstrate accessing parent fields using super
    public void showParentFields() {
        System.out.println("=== Accessing Parent Fields via super ===");
        System.out.println("super.brand      : " + super.brand);
        System.out.println("super.model      : " + super.model);
        System.out.println("super.year       : " + super.year);
        System.out.println("super.price      : $" + super.price);
        System.out.println("super.ownerName  : " + super.ownerName);
        System.out.println("=========================================");
    }
}

// ============================================================
// MAIN CLASS: VehicleInsuranceSystem
// ============================================================
public class VehicleInsuranceSystem {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   VEHICLE INSURANCE SYSTEM - DEMO");
        System.out.println("   Demonstrating the super keyword");
        System.out.println("========================================\n");

        // ---- 1. Car Insurance Demo ----
        System.out.println("---------- CAR INSURANCE ----------");
        CarInsurance car = new CarInsurance("Honda", "Civic", 2024, 25000, 
                                            "John Doe", "Comprehensive", 4);
        car.displayVehicleInfo();               // Uses super.displayVehicleInfo()
        System.out.println();
        System.out.println("Insured Value: $" + car.calculateInsuredValue());  // Uses super.calculateInsuredValue()
        System.out.println();
        car.showParentFields();                 // Uses super.brand, super.model, etc.
        System.out.println();

        // ---- 2. Bike Insurance Demo ----
        System.out.println("---------- BIKE INSURANCE ----------");
        BikeInsurance bike = new BikeInsurance("Harley-Davidson", "Street 750", 2023, 12000, 
                                               "Jane Smith", true, false);
        bike.displayVehicleInfo();              // Uses super.displayVehicleInfo()
        System.out.println();
        System.out.println("Insured Value: $" + bike.calculateInsuredValue());  // Uses super.calculateInsuredValue()
        System.out.println();
        bike.showParentFields();                // Uses super.brand, super.model, etc.
        System.out.println();

        // ---- 3. Truck Insurance Demo ----
        System.out.println("---------- TRUCK INSURANCE ----------");
        TruckInsurance truck = new TruckInsurance("Volvo", "FH16", 2024, 150000, 
                                                  "Acme Logistics", true, 20.5);
        truck.displayVehicleInfo();             // Uses super.displayVehicleInfo()
        System.out.println();
        System.out.println("Insured Value: $" + truck.calculateInsuredValue());  // Uses super.calculateInsuredValue()
        System.out.println();
        truck.showParentFields();               // Uses super.brand, super.model, etc.
        System.out.println();

        // ---- Summary of super keyword usages ----
        System.out.println("========================================");
        System.out.println("   SUPER KEYWORD USAGE SUMMARY");
        System.out.println("========================================");
        System.out.println("1. super()        : Used in constructors to call parent");
        System.out.println("                     class constructor (e.g., super(brand, model,...))");
        System.out.println("2. super.method() : Used to call overridden parent methods");
        System.out.println("                     (e.g., super.displayVehicleInfo())");
        System.out.println("3. super.field    : Used to access parent class fields");
        System.out.println("                     (e.g., super.brand, super.model)");
        System.out.println("========================================");
    }
}