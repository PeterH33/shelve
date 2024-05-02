public class Shelf {
    public float width;
    public float height;
    public float depth;
    public float availableWidth;

    public Shelf(){

    }

    public Shelf(float width, float height, float depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.availableWidth = width;
    }

    public boolean bookCanFit(Book book){
        return (book.height <= height && book.depth <= depth);
    }

    public boolean spaceAvailableForBook(Book book){
        return (book.width <= availableWidth);
    }

    public void addBookToShelf(Book book){
        
    }
}
