package DatabaseOperations;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import java.util.List;

import Entities.Author;
import Entities.BookLibrary;

public class BookDBO {


    private static final String PERSISTENCE_UNIT_NAME = "libraryApp";
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    // Method To Fetch All BookLibrary Details From The Database
//    @SuppressWarnings("unchecked")
    public static List getAllBookDetails() {
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM BookLibrary s");
        List bookList = queryObj.getResultList();
        if (bookList != null && bookList.size() > 0) {
            return bookList;
        } else {
            return null;
        }
    }

    // Method To Add Create BookLibrary Details In The Database
    public static String createNewBook(int idAuthor, String title) throws IllegalAccessException {
        Author author = null;
        try {
            if (!transactionObj.isActive()) {
                transactionObj.begin();
            }
            author = AuthorDBO.getAuthor(idAuthor);
            BookLibrary newBookLibraryObj = new BookLibrary();
//        newBookLibraryObj.setId(getMaxBookId());
            newBookLibraryObj.setIdAuthor(author);
            newBookLibraryObj.setTitle(title);
            System.out.println(newBookLibraryObj.getIdAuthor());
            entityMgrObj.persist(newBookLibraryObj);
            transactionObj.commit();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Try again!"));
            return "index.xhtml";
        }
    }


    // Method To Delete The Selected BookLibrary Id From The Database
    public static String deleteBookDetails(int id) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        BookLibrary deleteBookLibraryObj = new BookLibrary();
        if (isBookIdPresent(id)) {
            deleteBookLibraryObj.setIdBook(id);
            entityMgrObj.remove(entityMgrObj.merge(deleteBookLibraryObj));
        }
        transactionObj.commit();
        return "index.xhtml?faces-redirect=true";
    }
    public static BookLibrary getBook(int id) throws Exception{
        TypedQuery<BookLibrary> user =   entityMgrObj .createQuery("SELECT a FROM BookLibrary a WHERE a.id=:id", BookLibrary.class).setParameter("id", id);
        System.out.println(user.getSingleResult());
        return user.getSingleResult();
    }

//    public static String updateBookDetails(int bookId, String name, String surname, String updatedBookTitle, String isbn, int year, int price) throws IllegalAccessException {
//        try {
//            if (!transactionObj.isActive()) {
//                transactionObj.begin();
//            }
//            if (isBookIdPresent(bookId)) {
//                System.out.println(name);
//                System.out.println(updatedBookTitle);
//                Query queryObj = entityMgrObj.createQuery("UPDATE BookLibrary s SET s.authorName=:name, s.authorSurname=:surname, s.title=:title,s.isbn=:isbn,s.price=:price,s.year=:year WHERE s.id= :id");
//                queryObj.setParameter("id", bookId);
//                queryObj.setParameter("name", name);
//                queryObj.setParameter("surname", surname);
//                queryObj.setParameter("year", year);
//                queryObj.setParameter("isbn", isbn);
//                queryObj.setParameter("price", price);
//                queryObj.setParameter("title", updatedBookTitle);
//                int updateCount = queryObj.executeUpdate();
//                if (updateCount > 0) {
//                    System.out.println("Record For Id: " + bookId + " Is Updated");
//                }
//            }
//            transactionObj.commit();
//            FacesContext.getCurrentInstance().addMessage("editBookForm:bookId", new FacesMessage("BookLibrary Record #" + bookId + " Is Successfully Updated In Db"));
//            return "bookEdit.xhtml";
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage("editBookForm:bookId", new FacesMessage("BookLibrary Record #" + bookId + " Is not in Db"));
//            return "bookEdit.xhtml";
//        }
//    }

    // Helper Method 1 - Fetch Maximum BookLibrary Id From The Database
    private static int getMaxBookId() {
        int maxBookId = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(s.id)+1 FROM BookLibrary s");
        if (queryObj.getSingleResult() != null) {
            maxBookId = (Integer) queryObj.getSingleResult();
        }
        return maxBookId;
    }

    // Helper Method 2 - Fetch Particular BookLibrary Details On The Basis Of BookLibrary Id From The Database
    private static boolean isBookIdPresent(int bookId) {
        boolean idResult = false;
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM BookLibrary s WHERE s.id = :id");
        queryObj.setParameter("id", bookId);
        BookLibrary selectedBookLibraryId = (BookLibrary) queryObj.getSingleResult();
        if (selectedBookLibraryId != null) {
            idResult = true;
        }
        return idResult;
    }
}