package lab.assignments;

// =====================================
// Fan class implementing Switchable
// =====================================
class Fan implements Switchable {
    private String location;
    private int speed;

    public Fan(String location) {
        this.location = location;
        this.speed = 1; // default speed
    }

    public Fan(String location, int speed) {
        this.location = location;
        this.speed = speed;
    }

    @Override
    public void turnOn() {
        System.out.println("Fan at " + location + " is now ON at speed " + speed);
    }
}