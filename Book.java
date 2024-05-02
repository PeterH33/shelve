public class Book {
    public String title;
    public String author;
    public String ISBN;
    public String genre;
    public String deweyDecimal;
    public String libraryOfCongressCode;
    public int publicationYear;
    public float width;
    public float height;
    public float depth;

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
