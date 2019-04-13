package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Reader {
    @Id
    private int idReader;
    private String nameReader;
    private String surnameReader;
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
