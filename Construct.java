package lab.practice;
class Phone {
    String brand;
    String model;
    float cost;

    //Default Constructor
    Phone() {
        brand = "Apple";
        model = "iPhone 17";
        cost = 82900;
    }
    //Parametrized Constructor
    Phone(String b, String m, float c) {
        brand = b;
        model = m;
        cost = c;
    }

    //Copy Constructor
    Phone(Phone p) {
        this.brand = p.brand;
        this.model = p.model;
        this.cost = p.cost;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Cost: " + cost);
    }
}

public class Construct {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Samsung", "S26", 75999);
        Phone phone2 = new Phone(phone1);
        Phone phone3 = new Phone();

        phone1.display();
        phone2.display();
        phone3.display();
    }
}