import java.util.ArrayList;

public class BookDatabase {
    // arraylist to store all the book information
    ArrayList<Book> available_books = new ArrayList<>();


    public void add_books(Book book_obj){
        available_books.add(book_obj);
    }
}
