package lab.assignments;

/**
 * This program demonstrates all 4 types of inner classes in Java:
 * 1. Member Inner Class (non-static nested class)
 * 2. Static Nested Class
 * 3. Local Inner Class (defined inside a method)
 * 4. Anonymous Inner Class (defined and instantiated in a single expression)
 */

public class InnerClassExample {

    // ============================================================
    // 1. MEMBER INNER CLASS (non-static nested class)
    // ============================================================
    // A regular inner class that has access to all members of the outer class,
    // including private members. It must be instantiated using an instance of
    // the outer class.
    private String outerMessage = "Hello from Outer Class!";

    class MemberInner {
        void display() {
            // Can access private members of the outer class
            System.out.println("  [Member Inner Class] Accessing outer class private field: \"" + outerMessage + "\"");
            System.out.println("  [Member Inner Class] This inner class is tied to an instance of OuterClass.");
        }
    }

    // ============================================================
    // 2. STATIC NESTED CLASS
    // ============================================================
    // A static nested class behaves like a top-level class but is nested for
    // packaging convenience. It CANNOT access non-static members of the outer
    // class directly. It does NOT require an instance of the outer class.
    private static String staticOuterMessage = "Hello from Static Outer Context!";

    static class StaticNested {
        void display() {
            // Can only access static members of the outer class
            System.out.println("  [Static Nested Class] Accessing static outer field: \"" + staticOuterMessage + "\"");
            System.out.println("  [Static Nested Class] This class does NOT need an instance of OuterClass.");
        }
    }

    // ============================================================
    // Method to demonstrate LOCAL INNER CLASS
    // ============================================================
    public void demonstrateLocalInnerClass() {
        // Local variable (must be effectively final or explicitly final in Java 8+)
        final String localMessage = "Hello from Local Context!";

        // 3. LOCAL INNER CLASS
        // A class defined inside a method. It is only accessible within that method.
        // It can access the enclosing method's final/effectively-final local variables.
        class LocalInner {
            void display() {
                System.out.println("  [Local Inner Class] Accessing local variable: \"" + localMessage + "\"");
                System.out.println("  [Local Inner Class] This class is defined inside a method and is only");
                System.out.println("                       visible within the scope of this method.");
            }
        }

        // Instantiate and use the local inner class
        LocalInner local = new LocalInner();
        local.display();
    }

    // ============================================================
    // Method to demonstrate ANONYMOUS INNER CLASS
    // ============================================================
    public void demonstrateAnonymousInnerClass() {
        // 4. ANONYMOUS INNER CLASS
        // A class without a name that is defined and instantiated in a single expression.
        // It is typically used to override methods of a class or interface on the fly.
        
        // Create an anonymous inner class that extends the Thread class
        Thread anonymousThread = new Thread() {
            @Override
            public void run() {
                System.out.println("  [Anonymous Inner Class] Running inside an anonymous Thread subclass!");
                System.out.println("  [Anonymous Inner Class] This class is defined and instantiated in one go.");
            }
        };

        // Alternatively, using a Runnable interface
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("  [Anonymous Inner Class] Running inside an anonymous Runnable implementation!");
            }
        };

        anonymousThread.start();
        new Thread(anonymousRunnable).start();

        // Give threads time to print output
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   INNER CLASS DEMONSTRATION IN JAVA");
        System.out.println("============================================\n");

        // --- 1. Member Inner Class ---
        System.out.println("1. MEMBER INNER CLASS:");
        System.out.println("   (A non-static class defined inside another class)");
        // To instantiate a member inner class, you need an instance of the outer class
        InnerClassExample outer = new InnerClassExample();
        InnerClassExample.MemberInner memberInner = outer.new MemberInner();
        memberInner.display();
        System.out.println();

        // --- 2. Static Nested Class ---
        System.out.println("2. STATIC NESTED CLASS:");
        System.out.println("   (A static class defined inside another class)");
        // Static nested class can be instantiated without an outer class instance
        InnerClassExample.StaticNested staticNested = new InnerClassExample.StaticNested();
        staticNested.display();
        System.out.println();

        // --- 3. Local Inner Class ---
        System.out.println("3. LOCAL INNER CLASS:");
        System.out.println("   (A class defined inside a method)");
        outer.demonstrateLocalInnerClass();
        System.out.println();

        // --- 4. Anonymous Inner Class ---
        System.out.println("4. ANONYMOUS INNER CLASS:");
        System.out.println("   (A class without a name, defined and instantiated together)");
        outer.demonstrateAnonymousInnerClass();
        System.out.println();

        System.out.println("============================================");
        System.out.println("   END OF DEMONSTRATION");
        System.out.println("============================================");
    }
}