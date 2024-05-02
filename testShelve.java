import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testShelve{
    @Test
    public void testBookCanFit(){
        Book book = new Book();
        book.height = 10;
        book.depth = 9;
        Shelf shelf = new Shelf();
        shelf.height = 11;
        shelf.depth = 10;
        assertTrue(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitHeight(){
        Book book = new Book();
        book.height = 100;
        book.depth = 9;
        Shelf shelf = new Shelf();
        shelf.height = 11;
        shelf.depth = 10;
        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testBookCanNotFitDepth(){
        Book book = new Book();
        book.height = 10;
        book.depth = 90;
        Shelf shelf = new Shelf();
        shelf.height = 11;
        shelf.depth = 10;
        assertFalse(shelf.bookCanFit(book));
    }

    @Test
    public void testSpaceAvailibleBook(){
        Book book = new Book("name", 10, 10, 10);
        Shelf shelf = new Shelf(100, 20, 20);
        assertTrue(shelf.spaceAvailableForBook(book));
    }

    @Test
    public void testAddNode(){
        DLL<Integer> dll = new DLL<>();
        dll.add(1);
        dll.add(23);
        assertTrue(dll.getTail().getValue() == 23);
        assertTrue(dll.getHead().getValue() == 1);
    }
}