public class Library {
    private DLL<Book> uncategorizedBooks;
    private DLL<Book> shelvedBooks;
    private DLL<Book> oversizedBooks;
    private DLL<Shelf> shelves;

    public void shelveBooks() {
        // books must be sorted before shelving
        // go through books, placing on shelves until shelf is full then moving onto
        // next shelf
        // if book is too large, place it in oversized books
        // When uncategorizedBooks or shelves has reached its end, the shelving has
        // completed.
    }

    /**
     * Add a book to the library, all books are added as Uncategorized Books
     * 
     * @param book
     */
    public void addBook(Book book) {
        uncategorizedBooks.add(book);
    }

    /**
     * This method puts all book back into the uncategorizedBooks pile
     */
    public void pileBooks() {
        uncategorizedBooks.joinWith(shelvedBooks);
        uncategorizedBooks.joinWith(oversizedBooks);
    }

    public void printLibrary() {

    }
}