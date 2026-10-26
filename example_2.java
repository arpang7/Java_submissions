package lab.assignments;
class example_2 {
    int id;
    String name;
    public static void main(String[] args) {
        example_2 s1 = new example_2();
        s1.id = 101;
        s1.name = "Alice";
        System.out.println(s1.id + " " + s1.name);

        example_2 s2 = new example_2();
        s2.id = 102;
        s2.name = "Bob";
        System.out.println(s2.id + " " + s2.name);
    }
}
