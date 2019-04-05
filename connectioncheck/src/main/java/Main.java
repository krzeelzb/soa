import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("connectioncheck");
        EntityManager em = factory.createEntityManager();
        try {
            Car s1 = new Car();
            s1.setMark("lala");

            em.getTransaction().begin();
            em.persist(s1);

            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + s1);

            Query queryObj = em.createQuery("SELECT s FROM Car s");
            List bookList = queryObj.getResultList();
            System.out.println(bookList);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }
}