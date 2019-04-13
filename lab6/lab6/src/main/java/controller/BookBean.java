package controller;

import DatabaseOperations.BookDBO;
import Entities.Author;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "book")
public class BookBean {

    private int id;
    private String editId;
    private Author idAuthor;
    private int idAuthorSelected;
    private String title;

    public List bookListFromDb() {
        return BookDBO.getAllBookDetails();
    }

    public String addNewBook() throws IllegalAccessException {
        return BookDBO.createNewBook(idAuthorSelected,title);
    }

    public String deleteBookById(int id) {
        return BookDBO.deleteBookDetails(id);
    }

    // Method To Navigate User To The Edit Details Page And Passing Selecting BookLibrary Id Variable As A Hidden Value
    public String editBookDetailsById() {
        editId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedBookId");
        return "bookEdit.xhtml";
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEditId() {
        return editId;
    }
    public void setEditId(String editId) {
        this.editId = editId;
    }
    public int getIdAuthorSelected() {
        return idAuthorSelected;
    }

    public void setIdAuthorSelected(int idAuthorSelected) {
        this.idAuthorSelected = idAuthorSelected;
    }

}
