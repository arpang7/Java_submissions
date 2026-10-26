package lab.assignments;

/**
 * BookFinal - Demonstrates using the 'final' keyword for a book ISBN
 * that cannot be changed after object creation.
 * 
 * Key Concepts:
 * 1. final instance variable (isbn) - assigned once in constructor
 * 2. No setter for the final field - compiler enforces immutability
 * 3. Attempting to reassign the final field causes a compile-time error
 * 4. Displays book's ISBN, title, author, and price
 */
public class BookFinal {

    // ============================================================
    // INSTANCE VARIABLES
    // ============================================================
    
    // FINAL field: ISBN can only be set once (in constructor)
    private final String isbn;
    
    // Non-final fields: can be modified after creation
    private String title;
    private String author;
    private double price;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================
    
    /**
     * Constructor - initializes all fields including the final isbn.
     * The final field MUST be assigned exactly once, either at declaration
     * or in every constructor.
     */
    public BookFinal(String isbn, String title, String author, double price) {
        this.isbn = isbn;       // Final field assigned here
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // ============================================================
    // GETTERS (No setter for isbn - it's final!)
    // ============================================================
    
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    // ============================================================
    // SETTERS (Only for non-final fields)
    // ============================================================
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // ============================================================
    // BUSINESS METHODS
    // ============================================================
    
    /**
     * Applies a discount percentage to the book's price.
     */
    public void applyDiscount(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            double discountAmount = price * (discountPercent / 100);
            price -= discountAmount;
            System.out.println("Discount of " + discountPercent + "% applied. Saved: $" + String.format("%.2f", discountAmount));
        } else {
            System.out.println("Invalid discount percentage: " + discountPercent + "%");
        }
    }

    /**
     * Displays complete book information.
     */
    public void displayBookInfo() {
        System.out.println("=====================================");
        System.out.println("         BOOK DETAILS");
        System.out.println("=====================================");
        System.out.println("ISBN              : " + isbn);
        System.out.println("Title             : " + title);
        System.out.println("Author            : " + author);
        System.out.println("Price             : $" + String.format("%.2f", price));
        System.out.println("ISBN is final     : " + isImmutable());
        System.out.println("=====================================");
    }

    /**
     * Demonstrates that the ISBN reference is immutable.
     */
    private String isImmutable() {
        return "YES (cannot be changed after creation)";
    }

    // ============================================================
    // MAIN METHOD - DEMONSTRATION
    // ============================================================
    
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  LIBRARY BOOK MANAGEMENT — final KEYWORD DEMO");
        System.out.println("================================================\n");

        // ---- 1. Create a new book (ISBN is set via constructor) ----
        System.out.println(">>> CREATING BOOK...");
        BookFinal book1 = new BookFinal("978-0-13-468599-1", "The Java Programming", "James Gosling", 45.99);
        book1.displayBookInfo();
        System.out.println();

        // ---- 2. Demonstrate that ISBN CANNOT be changed ----
        System.out.println(">>> DEMONSTRATING final FIELD BEHAVIOR:");
        System.out.println("    - ISBN is declared 'final', so it cannot be reassigned.");
        System.out.println("    - There is NO setter for ISBN — the compiler enforces this.");
        System.out.println("    - The ISBN remains: " + book1.getIsbn());
        System.out.println();

        /* 
         *  COMPILE ERROR DEMONSTRATION (uncomment to see the error):
         *  
         *  book1.isbn = "978-0-00-000000-0";  
         *  // ERROR: cannot assign a value to final variable isbn
         *  
         *  OR if we had a setter:
         *  book1.setIsbn("978-0-00-000000-0"); 
         *  // ERROR: cannot find symbol (no setter exists)
         * 
         *  The 'final' keyword guarantees the ISBN
         *  remains constant throughout the object's lifetime.
         */

        // ---- 3. Modify non-final fields (these are allowed!) ----
        System.out.println(">>> MODIFYING NON-FINAL FIELDS (allowed):");
        book1.setTitle("The Java Programming Language");  // Title update
        book1.setAuthor("James Gosling & Bill Joy");       // Author update
        System.out.println("    Title updated to : " + book1.getTitle());
        System.out.println("    Author updated to: " + book1.getAuthor());
        System.out.println();

        // ---- 4. Apply discount ----
        System.out.println(">>> APPLYING DISCOUNT:");
        book1.applyDiscount(10);
        System.out.println("    New price: $" + String.format("%.2f", book1.getPrice()));
        System.out.println();

        // ---- 5. Display final state ----
        book1.displayBookInfo();
        System.out.println();

        // ---- 6. Create additional books to show different final ISBNs ----
        System.out.println(">>> ADDITIONAL BOOKS (different final ISBN values):");
        
        BookFinal book2 = new BookFinal("978-0-596-51774-8", "Head First Java", "Kathy Sierra", 39.99);
        book2.displayBookInfo();
        System.out.println();

        BookFinal book3 = new BookFinal("978-0-321-35668-0", "Effective Java", "Joshua Bloch", 49.99);
        book3.displayBookInfo();
        System.out.println();

        // ---- 7. final local variable example ----
        System.out.println(">>> FINAL LOCAL VARIABLE DEMO:");
        final String libraryName = "Central Library";
        System.out.println("    Library: " + libraryName);
        // libraryName = "Town Library";  // Would cause compile error!
        System.out.println("    (libraryName is a 'final' local variable — also immutable)");
        System.out.println();

        // ---- Summary ----
        System.out.println("================================================");
        System.out.println("  SUMMARY: final KEYWORD BEHAVIOR");
        System.out.println("================================================");
        System.out.println("  ✓ ISBN is declared as 'private final String'");
        System.out.println("  ✓ It is assigned once in the constructor");
        System.out.println("  ✓ No setter method exists for ISBN");
        System.out.println("  ✓ Any reassignment attempt causes a compile-time error");
        System.out.println("  ✓ Non-final fields (title, author, price) remain modifiable");
        System.out.println("  ✓ Each book object has its own unique, immutable ISBN");
        System.out.println("================================================");
    }
}