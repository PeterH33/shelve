import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testShelve {
    // Note, need to test and retrieve times for books n= 35,000 -> 1,500,000
    @Test
    public void testBookCanFit() {
        Book book = new Book("", 10, 1, 9);
        Shelf shelf = new Shelf("A", 20, 11, 10);
        assertTrue(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitHeight() {
        Book book = new Book("", 100, 1, 9);
        Shelf shelf = new Shelf("a", 20, 11, 10);
        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitDepth() {
        Book book = new Book("", 10, 1, 90);
        Shelf shelf = new Shelf("a", 20, 11, 10);

        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testSpaceAvailibleBook() {
        Book book = new Book("name", 10, 10, 10);
        Shelf shelf = new Shelf("a", 100, 20, 20);
        assertTrue(shelf.spaceAvailableForBook(book));
    }

    @Test
    public void testAddNode() {
        DLL<Integer> dll = new DLL<>();
        dll.add(1);
        dll.add(23);
        assertTrue(dll.getTail().getValue() == 23);
        assertTrue(dll.getHead().getValue() == 1);
    }

    // Test requires visual confirmation, refactor to be automated
    @Test
    public void testMergeSort() {
        System.out.println("Merge sort check of 100 random strings List before sort:");
        DLL<String> dll = new DLL<>();
        for (int i = 0; i < 100; i++) {
            dll.add(RandomString.randomString(6));
        }
        dll.printAll();
        dll.sort();
        System.out.println("After sorting");
        dll.printAll();
    }

    @Test
    public void testShelving() {
        // make library
        // create books
        // sort books onto shelves
    }

    // TODO: refactor for automation
    @Test
    public void testJoinWith() {
        DLL<Integer> left = new DLL<Integer>();
        DLL<Integer> right = new DLL<Integer>();
        left.add(1);
        left.add(2);
        right.add(3);
        right.add(4);
        left.add(5);
        left.joinWith(right);
        System.out.println(left.getTail());
        left.printAll();

    }

    @Test
    public void testJoinWithHeadNull() {
        DLL<Integer> left = new DLL<Integer>();
        DLL<Integer> right = new DLL<Integer>();
        right.add(3);
        right.add(4);
        left.joinWith(right);
        left.printAll();
        right.printAll();
    }

    //Refactor test for automation
    @Test
    public void testLibraryAddBook(){
        Library lib = new Library();
        Book book = new Book("A Book", 10, 10, 10);
        lib.addBook(book);
        lib.printLibrary();
    }

    //bad test, refactor for automation
    @Test
    public void testMoveBookToShelves(){
        Library lib = new Library();
        Book book = new Book("A Book", 10, 10, 10);
        lib.addBook(book);
        lib.printLibrary();
        System.out.println("After move");
        Node<Book> bookNode = lib.uncategorizedBooks.getHead();
        lib.moveBookToOverSized(bookNode);
        lib.printLibrary();
    }
}