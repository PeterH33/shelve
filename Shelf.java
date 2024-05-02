public class Shelf {
    private float width;
    private float height;
    private float depth;
    private float availableWidth;


    public Shelf(){

    }

    public Shelf(float width, float height, float depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.availableWidth = width;
    }

    public boolean bookCanFit(Book book){
        return (book.getHeight() <= height && book.getDepth() <= depth);
    }

    public boolean spaceAvailableForBook(Book book){
        return (book.getWidth() <= availableWidth);
    }

    public void addBookToShelf(Book book){

    }
}
