public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private String deweyDecimal;
    private String libraryOfCongressCode;
    private int publicationYear;
    private float width;
    private float height;
    private float depth;

    public float getWidth(){
        return this.width;
    }

    public float getHeight(){
        return this.height;
    }

    public float getDepth(){
        return this.depth;
    }

    public Book(){
        //Just setting the default constructor up again, this works by defining everything as a 0 state or null
    }

    public Book(String title, float height, float width, float depth){
        this.title = title;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
