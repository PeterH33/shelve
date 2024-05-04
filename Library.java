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
        pileBooks();
        uncategorizedBooks.sort();

        // go through books, placing on shelves until shelf is full then moving onto next shelf
        Node<Book> currentBook = uncategorizedBooks.getHead();
        Node<Shelf> currentShelf = shelves.getHead();
        while (currentBook != null){
            Node<Book> nextBook = currentBook.getNext();
            // if book is too large, place it in oversized books
            if (!currentShelf.getValue().bookCanFit(currentBook.getValue())){
                moveBookToOverSized(currentBook);
                currentBook = nextBook;
                continue;
            //Else see if the shelf is full, move to next shelf if full
            } else if (!currentShelf.getValue().spaceAvailableForBook(currentBook.getValue())){
                if (currentShelf.getNext() != null){
                    currentShelf = currentShelf.getNext();
                } else {
                    //out of shelves, all remaining books remain uncategorized
                    return;
                }
            }
            moveBookToShelf(currentBook);
            currentShelf.getValue().removeSpaceFromShelf(currentBook);
            currentBook = nextBook;
        }
    }

    /**
     * Add a book to the library, all books are added as Uncategorized Books
     * 
     * @param book
     */
    public void addBook(Book book) {
        uncategorizedBooks.add(book);
    }

    public void addShelf(Shelf shelf){
        shelves.add(shelf);
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