package Entities;

import javax.persistence.*;

@Entity
public class BookLibrary {
    @Id
    @GeneratedValue
    private int idBook;

    private String title;

    @ManyToOne
    private Author idAuthor;

    public BookLibrary(String title, Author author) {
        this.title=title;
        this.idAuthor = author;
    }

    public BookLibrary() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }


}
