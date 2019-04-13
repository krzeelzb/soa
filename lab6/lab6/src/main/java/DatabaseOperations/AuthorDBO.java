package DatabaseOperations;

import Entities.Author;
import Entities.BookLibrary;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorDBO {

    private static final String PERSISTENCE_UNIT_NAME = "libraryApp";
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    public static List getAllDetails() {
        CriteriaQuery<Author> query=entityMgrObj.getCriteriaBuilder().createQuery(Author.class);

        Root <Author> authors= query.from(Author.class);
        query.select(authors);

        TypedQuery<Author> queryObj= entityMgrObj.createQuery(query);
//        Query queryObj = entityMgrObj.createQuery("SELECT s FROM Author s");
        List bookList = queryObj.getResultList();
        if (bookList != null && bookList.size() > 0) {
            return bookList;
        } else {
            return null;
        }
    }
    public static Author getAuthor(int id) throws Exception{
        TypedQuery<Author> user =   entityMgrObj .createQuery("SELECT a FROM Author a WHERE a.id=:id", Author.class).setParameter("id", id);
        System.out.println(user.getSingleResult());
        return user.getSingleResult();
    }

    public static String createNewAuthor(String name, String surname) throws IllegalAccessException {
        Author author = null;
        try {
            if (!transactionObj.isActive()) {
                transactionObj.begin();
            }
            Author newAuthor = new Author();
//        newBookLibraryObj.setId(getMaxBookId());
            newAuthor.setNameAuthor(name);
            newAuthor.setSurnameAuthor(surname);
            System.out.println(newAuthor.getIdAuthor());
            entityMgrObj.persist(newAuthor);
            transactionObj.commit();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Try again!"));
            return "index.xhtml";
        }
    }

    public static String deleteAuthorDetails(int id) {
        try {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        BookLibrary deleteBookLibraryObj = new BookLibrary();
        if (isAuthorIdPresent(id)) {
            deleteBookLibraryObj.setIdBook(id);
            entityMgrObj.remove(entityMgrObj.merge(deleteBookLibraryObj));
        }
        transactionObj.commit();
        return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Try again!"));
            return "index.xhtml";
        }
    }
    private static boolean isAuthorIdPresent(int bookId) {
        boolean idResult = false;
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM Author s WHERE s.id = :id");
        queryObj.setParameter("id", bookId);
        Author selectedBookLibraryId = (Author) queryObj.getSingleResult();
        if (selectedBookLibraryId != null) {
            idResult = true;
        }
        return idResult;
    }

}
