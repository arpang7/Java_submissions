package lab.assignments;

// =====================================
// Light class implementing Switchable
// =====================================
class Light implements Switchable {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println("Light at " + location + " is now ON");
    }
}