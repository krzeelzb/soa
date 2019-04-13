package DatabaseOperations;

import Entities.*;
import Entities.Rent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RentDBO {
    private static final String PERSISTENCE_UNIT_NAME = "libraryApp";
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    public static List getAllDetails() {
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM Rent s");
        List bookList = queryObj.getResultList();
        if (bookList != null && bookList.size() > 0) {
            return bookList;
        } else {
            return null;
        }
    }

    public static String createNewRent(int idBook, int idReader, String date1,String date2) throws IllegalAccessException {
        BookLibrary book = null;
        Reader reader = null;
        try {
            if (!transactionObj.isActive()) {
                transactionObj.begin();
            }
            book = BookDBO.getBook(idBook);
            reader = ReaderDBO.getReader(idReader);



            Rent newRentLibraryObj = new Rent();
//        newRentLibraryObj.setId(getMaxRentId());
            newRentLibraryObj.setIdBookLibrary(book);
            newRentLibraryObj.setIdReader(reader);
            newRentLibraryObj.setDateStart(date1);
            newRentLibraryObj.setDateEnd(date2);
            entityMgrObj.persist(newRentLibraryObj);
            transactionObj.commit();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Try again!"));
            return "index.xhtml";
        }
    }
    public static String deleteRentDetails(int id) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        Rent deleteRentLibraryObj = new Rent();
        if (isRentIdPresent(id)) {
            deleteRentLibraryObj.setIdRent(id);
            entityMgrObj.remove(entityMgrObj.merge(deleteRentLibraryObj));
        }
        transactionObj.commit();
        return "index.xhtml?faces-redirect=true";
    }


    private static boolean isRentIdPresent(int rentId) {
        boolean idResult = false;
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM Rent s WHERE s.id = :id");
        queryObj.setParameter("id", rentId);
        Rent selectedRentLibraryId = (Rent) queryObj.getSingleResult();
        if (selectedRentLibraryId != null) {
            idResult = true;
        }
        return idResult;
    }
}
