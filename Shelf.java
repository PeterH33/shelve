public class Shelf {
    private String id;
    private float width;
    private float height;
    private float depth;
    private float availableWidth;
    private Node<Book> firstBook;
    private Node<Book> lastBook;

    public Shelf(String id, float width, float height, float depth) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.availableWidth = width;
    }

    public void setFirstBook(Node<Book> book) {
        this.firstBook = book;
        if (lastBook == null) {
            this.lastBook = book;
        }
    }

    public void setLastBook(Node<Book> book) {
        this.lastBook = book;
        if (firstBook == null) {
            this.firstBook = book;
        }
    }

    public void clearShelf() {
        this.firstBook = null;
        this.lastBook = null;
        availableWidth = width;
    }

    public boolean bookCanFit(Book book) {
        return (book.getHeight() <= height && book.getDepth() <= depth);
    }

    public boolean spaceAvailableForBook(Book book) {
        return (book.getWidth() <= availableWidth);
    }

    public void printBooksOnShelf() {
        System.out.println("Shelf: " + id);
        if (firstBook == lastBook) {
            System.out.println(firstBook.getValue().getTitle());
        } else if (firstBook == null) {
            System.out.println("Shelf empty");
        } else {
            Node<Book> tempNode = firstBook;
            while (firstBook != lastBook.getNext()) {
                System.out.println(tempNode.getValue().getTitle());
                tempNode = tempNode.getNext();
            }
        }
    }
}
