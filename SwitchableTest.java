package lab.assignments;

// =====================================
// Driver Class to Demonstrate Switchable Interface
// =====================================
public class SwitchableTest {
    public static void main(String[] args) {
        System.out.println("========== SWITCHABLE INTERFACE DEMONSTRATION ==========");
        System.out.println("Demonstrating Interface Implementation & Polymorphism\n");

        // Creating Light and Fan objects
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        Fan livingRoomFan = new Fan("Living Room");
        Fan bedroomFan = new Fan("Bedroom", 3);

        // Using Switchable interface reference (polymorphism)
        Switchable[] devices = {livingRoomLight, bedroomLight, livingRoomFan, bedroomFan};

        for (Switchable device : devices) {
            device.turnOn();
        }

        System.out.println("\n========== DEMONSTRATED SUCCESSFULLY ==========");
        System.out.println("Interface: Switchable");
        System.out.println("Implementations: Light, Fan");
        System.out.println("Polymorphism: Both stored as Switchable references");
    }
}