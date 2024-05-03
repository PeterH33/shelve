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

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getDepth() {
        return this.depth;
    }

    public String getTitle() {
        return this.title;
    }

    public Book(String title, float height, float width, float depth) {
        this.title = title;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
