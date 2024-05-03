public class Library {
    private DLL<Book> uncategorizedBooks;
    private DLL<Book> shelvedBooks;
    private DLL<Book> oversizedBooks;
    private DLL<Shelf> shelves;


    public void shelveBooks(){
        //books must be sorted before shelving
        //go through books, placing on shelves until shelf is full then moving onto next shelf
        //if book is too large, place it in oversized books
        //When uncategorizedBooks or shelves has reached its end, the shelving has completed.
    }

/**
 * Add a book to the library, all books are added as Uncategorized Books
 * @param book
 */
    public void addBook(Book book){
        uncategorizedBooks.add(book);
    }

    //need a function to put all the books back in uncategorizedBooks
    public void pileBooks(){
        //join all 3 DLL<Book> and set the head and tail of uncategorizedBooks to the start and end
        //set head and 
    }

    public void printLibrary(){

    }
}