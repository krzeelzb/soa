package Entities;

import javax.persistence.*;

@Entity
public class Rent {

    @Id
    @GeneratedValue
    private int idRent;
    @OneToOne
    @JoinColumn(name = "idBook")
    private BookLibrary idBookLibrary;
    @OneToOne
    @JoinColumn(name = "idReader")
    private Reader idReader;
    private String dateStart;
    private String dateEnd;

    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public BookLibrary getIdBookLibrary() {
        return idBookLibrary;
    }

    public void setIdBookLibrary(BookLibrary idBookLibrary) {
        this.idBookLibrary = idBookLibrary;
    }

    public Reader getIdReader() {
        return idReader;
    }

    public void setIdReader(Reader idReader) {
        this.idReader = idReader;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }


}
