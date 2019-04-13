package DatabaseOperations;

import Entities.Reader;

import javax.persistence.*;
import java.util.List;

public class ReaderDBO {
    private static final String PERSISTENCE_UNIT_NAME = "libraryApp";
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    public static List getAllDetails() {
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM Reader s");
        List bookList = queryObj.getResultList();
        if (bookList != null && bookList.size() > 0) {
            return bookList;
        } else {
            return null;
        }
    }

    public static Reader getReader(int id) throws Exception{
        TypedQuery<Reader> user =   entityMgrObj .createQuery("SELECT a FROM Reader a WHERE a.id=:id", Reader.class).setParameter("id", id);
        System.out.println(user.getSingleResult());
        return user.getSingleResult();
    }

}
