##PSEUDOCODE FOR BOOK APPLICATION TO SIMULATE DATABASE

The Project has three classes
    1) BookApp application class where the main() method is available
    2) Book class which is used to create Book object 
    3) BookDatabase class which stores all the books in arraylist

1) Pseudocode for The BookApp class with main() method 

The Application class has six methods:

	1.1) menu_welcome() method which prompts with menu of four options 
		(add a book, search a book, display all books and exit)
	1.2) add_a_book() method
	1.3) search() method
	1.4) display_all() method
	1.5) print_column_head() method
	1.6) print_book() method

declare static variables for print_dashes so that all methods to share easily 
declare static variables for number_of_books_in_db so that all methods to share easily 
instantiate database class
instantiate scanner class

##START
initialize six book objects
add all the six books to database (hardcoded for check up only user is supposed to enter latter)
prompt user with welcome statement
call menu_welcome() method
	declare variable input to scan user input
	declare book_sku variable to scan user input
	prompt user to choose (1/2/3/any other key)
	    IF (user enters 1) means all a book
	        call add_a_book() method
        ELSE IF (user enters 2) means search for a book
            prompt user to enter sku number
            scan and assign it a varaible
            call search() method with the sku number as a parameter
        ELSE IF (user enters 3) means display all
            call display_all() method
        ELSE
            prompt user to have good day!
        END IF
##END
