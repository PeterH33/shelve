import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testShelve {
    //Note, need to test and retrieve times for books n= 35,000 -> 1,500,000
    @Test
    public void testBookCanFit() {
        Book book = new Book("", 10, 1, 9);
        Shelf shelf = new Shelf(20,11,10);
        assertTrue(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitHeight() {
        Book book = new Book("", 100, 1, 9);
        Shelf shelf = new Shelf(20,11,10);
        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitDepth() {
        Book book = new Book("", 10, 1, 90);
        Shelf shelf = new Shelf(20,11,10);
      
        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testSpaceAvailibleBook() {
        Book book = new Book("name", 10, 10, 10);
        Shelf shelf = new Shelf(100, 20, 20);
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

    //Test requires visual confirmation, refactor to be automated
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

}