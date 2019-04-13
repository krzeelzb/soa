package Controllers;

import DatabaseOperations.ReaderDBO;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "reader")
public class ReaderBean {
    private int idReader;
    private String nameReader;
    private String surnameReader;

    public List readerListFromDb() {
        return ReaderDBO.getAllDetails();
    }
    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public String getNameReader() {
        return nameReader;
    }

    public void setNameReader(String nameReader) {
        this.nameReader = nameReader;
    }

    public String getSurnameReader() {
        return surnameReader;
    }

    public void setSurnameReader(String surnameReader) {
        this.surnameReader = surnameReader;
    }



}
