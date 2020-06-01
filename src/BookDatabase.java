import java.util.ArrayList;

public class BookDatabase {
    Book book_found = new Book();
    // arraylist to store all the book information
    ArrayList<Book> available_books = new ArrayList<>();


    // check if sku entered is unique
    public boolean is_sku_unique(String sku) {
        boolean sku_occupied = false;
        for (int i = 0; i < available_books.size(); i++) {

            if (available_books.get(i).getSku().equals(sku)) {
                sku_occupied = true;
            }
        }
        return sku_occupied;
    }

    // ADD A BOOK METHOD
    public void add_books(Book book_obj) {
        available_books.add(book_obj);
    }

    public int number_of_records() {
        return available_books.size();
    }

    // PRINT ALL RECORDS METHOD
    public Book display_all(int index) {

        book_found = available_books.get(index);
        return book_found;
    }

    // SEARCH A BOOK WITH SUK METHOD

    public Book search_a_book(String sku) {
            Book found_book = new Book();
            int count = 0;

        if (available_books.size() > 0) {

            for (int i = 0; i < available_books.size(); i++) {
                if (available_books.get(i).getSku().equals(sku)) {
                    found_book = available_books.get(i);
                    count++;
                }
            }
        }
        if(count != 0){
        return found_book;
        }
        else {
            return null;
        }
    }
}
