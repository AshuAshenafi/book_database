import java.util.Scanner;

public class BookApp {
    static String print_dashes = "";
    static int number_of_books_in_db = 0;
    // instantiate database object so that the book object will be saved in our pseudo database
    static BookDatabase book_db = new BookDatabase();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // INPUT
        // create object Book with its attributes
        Book book1 = new Book("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50);
        Book book2 = new Book("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00);
        Book book3 = new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky", "Everything you need to know in one place", 45.00);

        Book book4 = new Book("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50);
        Book book5 = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Simon Monk", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50);
        Book book6 = new Book("Rasp1006", "Rasperry Pi Projects for the Evil Genius", "Donald Norris", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75);

        // add to the database
        book_db.add_books(book1);
        book_db.add_books(book2);
        book_db.add_books(book3);

        book_db.add_books(book4);
        book_db.add_books(book5);
        book_db.add_books(book6);

        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println("*   Welcome to Pseudo Book Database.  *");
        System.out.println("* * * * * * * * * * * * * * * * * * * *");

        // welcome() to start to take user input and get main menu option
        menu_welcome();

    }   // end of main()

    // welcome
    public static void menu_welcome() {
        int input;
        String book_sku;
        // Prompt user to enter Book info

        System.out.print("\nEnter (1) to ADD new Book or \nEnter (2) to SEARCH for a Book \nEnter (3) to DISPLAY all Books Record:\nEnter (any other key) to exit: ");
        int user_need = keyboard.nextInt();
         keyboard.nextLine();
//        String user_need = input;

        // ask user to choose if user wants to add a book or to look for a book
        if (user_need == 1) {           // means to add a new book
            add_a_book();
        } else if (user_need == 2) {     // means to search for a book
            System.out.print("\nEnter Book SKU: ");
            book_sku = keyboard.nextLine();

            search(book_sku);
            keyboard.nextLine();

        } else if (user_need == 3) {     // display all from the database
            display_all();
        } else {
            System.out.println("Good bye! Thank you!");
        }
    }

    // add a book object
    public static void add_a_book() {

        String input;
        String book_sku;
        boolean cont2 = false;
        do {
            cont2 = true;

            System.out.print("\nEnter Book SKU: ");
            input = keyboard.nextLine();
            book_sku = input;
            boolean sku_in_use = false;
            number_of_books_in_db = book_db.number_of_records();

            if (number_of_books_in_db > 0) {

                sku_in_use = book_db.is_sku_unique(book_sku);

                if (sku_in_use) {
                    System.out.println("Sorry! The number is already taken.");
                    System.out.println("Please continue with unique SKU.");
                    System.out.println("------------------------------------");

                    menu_welcome();

                } else {
                    cont2 = false;
                }

            } else {
                cont2 = false;
            }

        } while (cont2 == true);


        System.out.print("Enter Book Title: ");
        input = keyboard.nextLine();
        String book_title = input;

        System.out.print("Enter Book Author(s): ");
        input = keyboard.nextLine();
        String book_author = input;

        System.out.print("Enter Book Description: ");
        input = keyboard.nextLine();
        String book_description = input;

        System.out.print("Enter Book Price: ");
        double price = keyboard.nextDouble();
        keyboard.nextLine();
        double book_price = price;

        Book book = new Book(book_sku, book_title, book_author, book_description, book_price);
        book_db.add_books(book);
        System.out.println("Book successfully added.");
        // back to the main menu
        menu_welcome();
    }   // end of add_a_book() method

    public static void search(String sku) {
        Book book_from_db;

        book_from_db = book_db.search_a_book(sku);

        if (book_from_db != null) {
            System.out.print("\nThe Book you are looking for: ");
            print_column_head();

            print_book(book_from_db.getSku(), book_from_db.getTitle(), book_from_db.getAuthor(), book_from_db.getDescription(), book_from_db.getPrice());
            menu_welcome();
        } else {
            System.out.println("Sorry we couldn't find your search for: " + sku);
            // back to the main menu
            menu_welcome();
        }
    }   // end of search() method

    public static void display_all() {
        number_of_books_in_db = book_db.number_of_records();

        if (number_of_books_in_db > 0) {

            System.out.println("List of All Books added: ");
            print_column_head();
            for (int i = 0; i < number_of_books_in_db; i++) {
                book_db.display_all(i);
                print_book(book_db.display_all(i).getSku(), book_db.display_all(i).getTitle(), book_db.display_all(i).getAuthor(), book_db.display_all(i).getDescription(), book_db.display_all(i).getPrice());
            }
        } else {
            System.out.println("No Book is added yet.");
        }
        // back to the main menu
        menu_welcome();
    }   // end of display_all() method

    public static void print_column_head() {
        print_dashes = "";
        print_dashes = "\n";
        for (int i1 = 0; i1 < 82; i1++) {
            print_dashes += "--";
        }
        System.out.print(print_dashes);
        System.out.printf("\n%1s %2s SKU %3s %20s Title %19s %13s Author %10s %25s Description %23s %2s Price%2s", "|", " ", "|", " ", "|", " ", "|", "", " ", "|", "|");
        System.out.print(print_dashes);

    }   // end of print_column_head() method

    public static void print_book(String sku, String title, String author, String description, double price) {
        System.out.printf("\n%-10s  %-45s  %-30s  %-65s  %-10s", sku, title, author, description, String.format("%(,.2f", price));
        System.out.print(print_dashes);
    }
}   // end of class

