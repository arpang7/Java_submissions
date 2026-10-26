package lab.assignments;
class Outer {
    class Inner {
        void display() {
            System.out.println("Inner class method");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.display();
    }
}
