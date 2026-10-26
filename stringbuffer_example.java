package lab.assignments;

public class stringbuffer_example {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer();

        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        System.out.println("StringBuffer: " + sb);
        sb.delete(5, 6);
        System.out.println("After deleting space: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Character at index 0: " + sb.charAt(0));
    }
}