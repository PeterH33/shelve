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

    public void printLibrary(){

    }
}