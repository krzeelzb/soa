import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "book")
public class BookBean {
    private int id;

    public String getEditId() {
        return editId;
    }

    public void setEditId(String editId) {
        this.editId = editId;
    }

    private String editId;
    private String authorName;
    private String editedAuthorName;
    private String authorSurname;
    private String editedAuthorSurname;
    private String title;
    private String editedTitle;
    private String isbn;
    private String editedIsbn;
    private int year;
    private int editedYear;
    private int editedPrice;
    private int price;
    private Boolean addBtn;



    public List bookListFromDb() {
        return DatabaseOperations.getAllBookDetails();
    }

    public String addNewBook(BookBean book) throws IllegalAccessException {
        return DatabaseOperations.createNewBook(book);
    }

    public String deleteBookById(int id) {
        return DatabaseOperations.deleteBookDetails(id);
    }

    // Method To Navigate User To The Edit Details Page And Passing Selecting Book Id Variable As A Hidden Value
    public String editBookDetailsById() {
        editId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedBookId");
        return "bookEdit.xhtml";
    }

    // Method To Update The Book Details In The Database
    public String updateBookDetails(BookBean schoolBean) throws IllegalAccessException  {
        return DatabaseOperations.updateBookDetails(Integer.parseInt(schoolBean.getEditId()),schoolBean.authorName,schoolBean.authorSurname, schoolBean.getTitle(),schoolBean.isbn,schoolBean.year,schoolBean.price);
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getEditedAuthorName() {
        return editedAuthorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getEditedAuthorSurname() {
        return editedAuthorSurname;
    }

    public String getTitle() {
        return title;
    }

    public String getEditedTitle() {
        return editedTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditedIsbn() {
        return editedIsbn;
    }

    public int getYear() {
        return year;
    }

    public int getEditedYear() {
        return editedYear;
    }

    public int getEditedPrice() {
        return editedPrice;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setEditedAuthorName(String editedAuthorName) {
        this.editedAuthorName = editedAuthorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setEditedAuthorSurname(String editedAuthorSurname) {
        this.editedAuthorSurname = editedAuthorSurname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditedTitle(String editedTitle) {
        this.editedTitle = editedTitle;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditedIsbn(String editedIsbn) {
        this.editedIsbn = editedIsbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEditedYear(int editedYear) {
        this.editedYear = editedYear;
    }

    public void setEditedPrice(int editedPrice) {
        this.editedPrice = editedPrice;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public Boolean getAddBtn() {
        System.out.println(addBtn);
        return addBtn;
    }

    public void setAddBtn(Boolean addBtn) {
        System.out.println(addBtn);
        this.addBtn = addBtn;
    }

    public int getPrice() {
        return price;
    }
    public int setPrice() {
        return price;
    }



}
