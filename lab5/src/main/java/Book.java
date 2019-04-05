import javax.persistence.*;

@Entity
public class Book {


    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private String authorSurname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int price;

    public Book(int id, String authorName, String authorSurname, String title, String isbn, int year, int price) {
        this.id = id;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
