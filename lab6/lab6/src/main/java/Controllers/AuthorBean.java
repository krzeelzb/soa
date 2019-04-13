package Controllers;

import DatabaseOperations.AuthorDBO;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "author")
public class AuthorBean {

    private int idAuthor;
    private String nameAuthor;
    private String surnameAuthor;

    public String addNewAuthor() throws IllegalAccessException {
        return AuthorDBO.createNewAuthor(nameAuthor, surnameAuthor);
    }

    public String deleteAuthorById(int id) {
        return AuthorDBO.deleteAuthorDetails(id);
    }

    public List authorListFromDb() {
        return AuthorDBO.getAllDetails();
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }


}
