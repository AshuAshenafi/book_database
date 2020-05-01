import java.util.Scanner;

public class BookApp {

    public static void main(String[] args) {

        // INPUT

        // instantiate scanner object
        Scanner keyboard = new Scanner(System.in);

        // variables
        String input;
        double price;
        String book_sku;
        String book_title;
        String book_author;
        String book_description;
        double book_price;

        // declare and initialize loop controling boolean variables
        boolean cont_add = false;
        boolean cont_search = false;
        boolean cont_display_all = false;
        boolean cont2 = true;

        // create object Book with its attributes
        Book book1 = new Book("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50);
        Book book2 = new Book("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00);
        Book book3 = new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky", "Everything you need to know in one place", 45.00);

        Book book4 = new Book("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50);
        Book book5 = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Simon Monk", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50);
        Book book6 = new Book("Rasp1006", "Rasperry Pi Projects for the Evil Genius", "Donald Norris", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75);

        // instantiate database object so that the book object will be saved in our pseudo database
        BookDatabase book_db = new BookDatabase();

        // add to the database
        book_db.add_books(book1);
        book_db.add_books(book2);
        book_db.add_books(book3);

        book_db.add_books(book4);
        book_db.add_books(book5);
        book_db.add_books(book6);

        // Prompt user to enter Book info
        System.out.println("Welcome to Pseudo Book Database.");
        System.out.println("--------------------------------");
        System.out.print("Enter (1) to ADD new Book or \nEnter (2) to SEARCH for a Book \nEnter (3) to DISPLAY all Books Record:\nEnter (any other key) to exit: ");
        input = keyboard.nextLine();
        String user_need = input;

        // ask user to choose if user wants to add a book or to look for a book
        if (user_need.equals("1")) {           // means to add a new book
            cont_add = true;
        } else if (user_need.equals("2")) {     // means to search for a book
            cont_search = true;
        } else if (user_need.equals("3")) {
            cont_display_all = true;
        } else{
            System.out.println("Good bye! Thank you!");
        }

        // TO ADD A BOOK WHICH IS NOT ALREADY IN THE DATABASE
        while (cont_add) {
            do {
                cont2 = true;

                System.out.print("\nEnter Book SKU: ");
                input = keyboard.nextLine();
                book_sku = input;
                boolean sku_in_use = false;

                if (book_db.available_books.size() > 0) {
                    for (int i = 0; i < book_db.available_books.size(); i++) {
                        if (book_db.available_books.get(i).getSku().equals(book_sku)) {
                            sku_in_use = true;
                        }
                    }
                    if (sku_in_use) {
                        System.out.println("That number is already taken.");
                        System.out.println("Please continue with unique SKU.");
                        System.out.println("-----------------------------");

                    } else {
                        cont2 = false;
                    }


                } else {
                    cont2 = false;
                }

            } while (cont2 == true);


            System.out.print("Enter Book Title: ");
            input = keyboard.nextLine();
            book_title = input;

            System.out.print("Enter Book Author(s): ");
            input = keyboard.nextLine();
            book_author = input;

            System.out.print("Enter Book Description: ");
            input = keyboard.nextLine();
            book_description = input;

            System.out.print("Enter Book Price: ");
            price = keyboard.nextDouble();
            keyboard.nextLine();
            book_price = price;

            Book book = new Book(book_sku, book_title, book_author, book_description, book_price);
            book_db.available_books.add(book);


            // prompt if user still want to add more books
            System.out.print("\nPress (q/Q) to quit or any other key to continue: ");
            String input1 = keyboard.nextLine();
            String want_quit2 = input1;

//            System.out.println("STOP - want_quit2.equalsIgnoreCase(\"q\")" + want_quit2.equalsIgnoreCase("q"));

            if (want_quit2.equalsIgnoreCase("q")) {
                cont_add = false;
            }
        }   // end of while loop for adding a book

        // to look for or SEARCH a BOOK

        while (cont_search) {
            System.out.print("\nEnter Book SKU: ");
            input = keyboard.nextLine();
            book_sku = input;
            if (book_db.available_books.size() > 0) {

                for (int i = 0; i < book_db.available_books.size(); i++) {
                    if (book_db.available_books.get(i).getSku().equals(book_sku)) {

                        System.out.println("The Book you are looking for: ");

                        System.out.printf("\n%7s SKU %7s Title %40s Author %32s Description %35s   Price\n", " ", " ", " ", " ", " ");
                        for (int i1 = 0; i1 < 85; i1++) {
                            System.out.print("--");
                        }

                        System.out.printf("\n%-10s  %-45s  %-30s  %-65s  %-10s", book_db.available_books.get(i).getSku(),
                                book_db.available_books.get(i).getTitle(), book_db.available_books.get(i).getAuthor(),
                                book_db.available_books.get(i).getDescription(), String.format("%(,.2f", book_db.available_books.get(i).getPrice()));

                        cont_search = false;
                    }
                }

            } else {
                System.out.println("No Book is added yet.");
            }
        }   // end of while loo for searching a book


        // to display all the record
        while (cont_display_all) {
            if (book_db.available_books.size() > 0) {

                System.out.println("List of All Books added: ");
                System.out.printf("\n%7s SKU %7s Title %40s Author %32s Description %35s   Price\n", " ", " ", " ", " ", " ");
                for(int i = 0; i < 85; i++){
                System.out.print("--");
                }
                for (int i = 0; i < book_db.available_books.size(); i++) {
                    System.out.printf("\n%-10s  %-45s  %-30s  %-65s  %-10s", book_db.available_books.get(i).getSku(),
                            book_db.available_books.get(i).getTitle(),book_db.available_books.get(i).getAuthor(),
                            book_db.available_books.get(i).getDescription() ,String.format("%(,.2f", book_db.available_books.get(i).getPrice()));
                }
                cont_display_all = false;

            } else {
                System.out.println("No Book is added yet.");
                cont_display_all = false;
            }
        }   // end of display all records while loop

    }   // end of main()

}   // end of class

