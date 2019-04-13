package controller;

import DatabaseOperations.RentDBO;
import Entities.BookLibrary;
import Entities.Reader;
import Entities.Rent;

import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "rent")
public class RentBean {
    private int idRent;
    private BookLibrary idBookLibrary;
    private Reader idReader;
    private String dateStart;
    private String dateEnd;
    private int idBookSelected;
    private int idReaderSelected;
    public static List rentListFromDb() {
        return RentDBO.getAllDetails();
    }

    public String addNewRent() throws IllegalAccessException {
        return RentDBO.createNewRent(idBookSelected,idReaderSelected,dateStart,dateEnd);
    }

    public String deleteRentById(int id) {
        return RentDBO.deleteRentDetails(id);
    }

    private int idAuthorSelected;

    public int getIdAuthorSelected() {
        return idAuthorSelected;
    }

    public void setIdAuthorSelected(int idAuthorSelected) {
        this.idAuthorSelected = idAuthorSelected;
    }


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

    public int getIdBookSelected() {
        return idBookSelected;
    }

    public void setIdBookSelected(int idBookSelected) {
        this.idBookSelected = idBookSelected;
    }

    public int getIdReaderSelected() {
        return idReaderSelected;
    }

    public void setIdReaderSelected(int idReaderSelected) {
        this.idReaderSelected = idReaderSelected;
    }


}
