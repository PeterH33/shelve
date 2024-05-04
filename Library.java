public class Library {
    public DLL<Book> uncategorizedBooks;
    private DLL<Book> shelvedBooks;
    private DLL<Book> oversizedBooks;
    private DLL<Shelf> shelves;

    public Library(){
        this.uncategorizedBooks = new DLL<Book>();
        this.shelvedBooks = new DLL<Book>();
        this.oversizedBooks = new DLL<Book>();
        this.shelves = new DLL<Shelf>();
    }

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

    public void moveBookToShelf(Node<Book> book){
        uncategorizedBooks.removeNode(book);
        shelvedBooks.addNode(book);
    }

    public void moveBookToOverSized(Node<Book> book){
        uncategorizedBooks.removeNode(book);
        oversizedBooks.addNode(book);
    }

    public void printLibrary() {
        System.out.println("Uncategorized books: ");
        uncategorizedBooks.printAll();
        System.out.println("Shelved Books: ");
        shelvedBooks.printAll();
        System.out.println("OverSized books: ");
        oversizedBooks.printAll();
    }
}