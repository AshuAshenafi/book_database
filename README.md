#Pseudo Database class using only Java
The  book database class will contain a method to return a book object. 
The program uses the knowledge on how to create a class. 
The class will simulate a database and return a populated book object. 
The program simulates a database by simply using if or switch statements to look up a book based on SKU. 

The book database will contain several book titles and the SKU code to look one up.

# HERE IS THE PSEUDOCODE AND TEST DATAS
/**
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * * *       PSEUDOCODE    * * * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Start
 * Instantiate Scanner Object
 * declare variable input, price, sku, title, author, description, price to scan from user
 * declare and initialize boolean control variables for while loops primarly false, internal loops (loops in loops true)
 * create book object to initialize teh the database with six books (but user will be prompted to insert additional books)
 * instantiate database class
 * add each book object created to database six books
 * //***********************
 * prompt user to choose between three options
 * print	1) press 1 to add a new book
 * 	2) press 2 to search for a book
 * 	3) press 3 to display all book records (select all)
 * scan user input
 * 	IF (user selects 1)
 * 		assign while loop control for adding a new book option true value
 * 		// program jumps to while loop for adding on line
 * 	ELSE IF ( user enters 2)
 * 		assign while loop control for searching existing book option true value
 * 		// program jumps to while loop for adding on line
 * 	ELSE IF (user enters 3){
 * 		assign while loop control for displaying all the book record
 * 		// program jumps to while loop for adding on line
 * 	ELSE
 * 		end the program
 * 	END IF
 * //********************************ADD A BOOK IF SKU NUMBER NOT ALREADY SAVED
 * 	WHILE LOOP (if control_add is true)
 * 		DO WHILE LOOP
 * 			assign loop control true to protect false entry from previous run
 * 			prompt user to enter book SKU:
 * 			scan user input String
 * 			assign sku number exists variable to be false first
 * 			// check if the SKU number already exists in the database
 * 				IF (the arraylist size is greater than zero)
 * 					FOR LOOP (index from zero to number of available books)
 * 						IF ( currently entered sku if equals to each and every sku in database)
 * 							assign sku is already in use to be true
 * 						END IF
 * 					END FOR LOOP
 * 						IF (book sku already exists)
 * 							prompt user that it is already in teh record
 * 							// the program loops back to line because Do-While control variable is still true
 * 						ELSE
 * 							assign do-while control variable false
 * 						END IF
 * 				ELSE
 * 					assign do-while loop control false
 * 				END IF
 * 		END DO WHILE LOOP
 * 		prompt user to enter Book Title
 * 		scan and assign book title vaiable
 *
 * 		prompt user ot enter book author/s
 * 		scan and assign varaiable
 *
 * 		prompt user to enter book description
 * 		scan and assign vairable
 *
 * 		prompt user to enter book price
 * 		scan and assign variable
 *
 * 		create book object with all currently entered book attributes
 * 		store the object in database
 *
 * 		prompt to hit (q/Q) to quit or anyother key if user wants to add another book
 * 		scan user input
 * 			IF (user hit q/Q)
 * 				assign while loop control false
 * 			END IF		// means if user hits any other key the while loop control is still true so it goes back
 *
 * // *********************SEARCH FOR A RECORD USING SKU NUMBER
 * 	WHILE LOOP (if control for search is true)
 * 		prompt user to enter SKU number
 * 		scan and assign a variable
 * 			IF (database or the arraylist size in database is greater than zero)
 * 				FOR (index from zero to length of database records)
 * 					IF ( chekc for the sku number if it is equal to any of the existing sku number)
 * 						keep the index number and output all the book attribute in repective database record
 * 					END IF
 * 				END FOR
 * 			ELSE
 * 				print no book is added yet.
 * 			END IF
 * 	END WHILE LOOP
 * //*********************** DISPLAY ALL AVAILABLE RECORD FROM DATABASE
 * 	WHILE (display all control is true)
 * 		IF (number of database record is greater than zero)
 * 			print list of books with proper formating
 * 		ELSE
 * 			print no book is added yet.
 * 		END IF
 * end
 *
 * * * * * * * * * * * * * * * * * *       TEST DATA - 1    * * * * * * * * * * * * * * * * * *
 *
 *Welcome to Pseudo Book Database.
 * --------------------------------
 * Enter (1) to ADD new Book or
 * Enter (2) to SEARCH for a Book
 * Enter (3) to DISPLAY all Books Record:
 * Enter (any other key) to exit 3
 * List of All Books added:
 *
 *         SKU         Title                                          Author                                  Description                                       Price
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Java1001    Head First Java                                Kathy Sierra and Bert Bates     Easy to read Java workbook                                         47.50
 * Java1002    Thinking in Java                               Bruce Eckel                     Details about Java under the hood                                  20.00
 * Orcl1003    OCP: Oracle Certified Professional Java SE     Jeanne Boyarsky                 Everything you need to know in one place                           45.00
 * Python1004  Automate the Boring Stuff with Python          Al Sweigart                     Fun with Python                                                    10.50
 * Zombie1005  The Maker's Guide to the Zombie Apocalypse     Simon Monk                      Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi   16.50
 * Rasp1006    Rasperry Pi Projects for the Evil Genius       Donald Norris                   A dozen fiendishly fun projects for the Raspberry Pi!              14.75
 *
 * * * * * * * * * * * * * * * * * *       TEST DATA - 2    * * * * * * * * * * * * * * * * * *
 *
 *Welcome to Pseudo Book Database.
 * --------------------------------
 * Enter (1) to ADD new Book or
 * Enter (2) to SEARCH for a Book
 * Enter (3) to DISPLAY all Books Record:
 * Enter (any other key) to exit: 1
 *
 * Enter Book SKU: Java1005
 * Enter Book Title: Java for Dummies
 * Enter Book Author(s): Doug Lowe
 * Enter Book Description: Java all in one for Dummies
 * Enter Book Price: 33.99
 *
 * Press (q/Q) to quit or any other key to continue:
 *
 * Enter Book SKU: Java1005
 * That number is already taken.
 * Please continue with unique SKU.
 * -----------------------------
 *
 * Enter Book SKU: Java1006
 * Enter Book Title: Java The Complete Reference
 * Enter Book Author(s): Herbert Schildt
 * Enter Book Description: Comprehensive guide to the entire Java language
 * Enter Book Price: 48.0
 *
 * Press (q/Q) to quit or any other key to continue: Q
 *
 * * * * * * * * * * * * * * * * * *       TEST DATA - 3    * * * * * * * * * * * * * * * * * **
 * Welcome to Pseudo Book Database.
 * --------------------------------
 * Enter (1) to ADD new Book or
 * Enter (2) to SEARCH for a Book
 * Enter (3) to DISPLAY all Books Record:
 * Enter (any other key) to exit: 2
 *
 * Enter Book SKU: Java1002
 * The Book you are looking for:
 *
 *         SKU         Title                                          Author                                  Description                                       Price
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * Java1002    Thinking in Java                               Bruce Eckel                     Details about Java under the hood                                  20.00
 */
