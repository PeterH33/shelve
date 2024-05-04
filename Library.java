import java.util.Random;

public class Library {
    public DLL<Book> uncategorizedBooks;
    private DLL<Book> shelvedBooks;
    private DLL<Book> oversizedBooks;
    private DLL<Shelf> shelves;

    public static void main(String[] args) {
        int bookCount = Integer.parseInt(args[0]);
        Library lib = new Library();
        for (int i = 0; i < bookCount; i++){
            lib.addBook(randomBook());
        }

        for (int i = 0; i < 5; i++){
            lib.addShelf(randomShelf());
        }
        System.out.println("=======Library before shelving =======");
        // lib.printLibrary();
        lib.shelveBooks();
        System.out.println(" ******** Library after shelving *********");
        // lib.printLibrary();
    }
    private static Random r = new Random();
    private static float randomFloat(float min, float max){
        return min + r.nextFloat() * (max-min);
    }

    private static Book randomBook(){
        return new Book(RandomString.randomString(6), randomFloat(17.0f, 29.0f), randomFloat(0.5f, 4.25f), randomFloat(10.0f, 20.0f));
    }

    private static Shelf randomShelf(){
        return new Shelf(RandomString.randomString(4), randomFloat(60.0f, 100.0f), randomFloat(24.0f, 40.0f), randomFloat(20.0f, 40.0f));
    }

    public Library(){
        this.uncategorizedBooks = new DLL<Book>();
        this.shelvedBooks = new DLL<Book>();
        this.oversizedBooks = new DLL<Book>();
        this.shelves = new DLL<Shelf>();
    }

    public void shelveBooks() {
        // books must be sorted before shelving
        long startTimePileBooks = System.nanoTime();
        pileBooks();
        long endTimePileBooks = System.nanoTime();
        long startTimeSort = System.nanoTime();
        uncategorizedBooks.sort();
        long endTimeSort = System.nanoTime();

        long startTimeShelf = System.nanoTime();
        long endTimeShelf = System.nanoTime();
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
                    endTimeShelf = System.nanoTime();
                    printTimes(startTimePileBooks, endTimePileBooks, startTimeSort, endTimeSort, startTimeShelf, endTimeShelf);
                    return;
                }
            }
            moveBookToShelf(currentBook);
            currentShelf.getValue().removeSpaceFromShelf(currentBook);
            currentBook = nextBook;
        }
        endTimeShelf = System.nanoTime();
        printTimes(startTimePileBooks, endTimePileBooks, startTimeSort, endTimeSort, startTimeShelf, endTimeShelf);
    }

    private void printTimes(long startTimePileBooks, long endTimePileBooks, long startTimeSort, long endTimeSort, long startTimeShelf, long endTimeShelf){
        System.out.println("Elapsed Time mS Pile Books: " + ((endTimePileBooks - startTimePileBooks)/1000000));
        System.out.println("Elapsed Time mS Sort Books: " + ((endTimeSort - startTimeSort)/1000000));
        System.out.println("Elapsed Time mS Categorize Books: " + ((endTimeShelf - startTimeShelf)/1000000));
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