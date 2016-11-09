import innopolis.course.entity.Student;
import innopolis.course.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Max Shalavin on 08.11.2016.
 */
public class JpaBasicsTutorial {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
        EntityManager em = emf.createEntityManager();
        StudentService service = new StudentService(em);

        System.out.println("--- Create and persist artist ---");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
//        Student student = service.createStudent(10,"asdasdasda");

        transaction.commit();
//        System.out.println(String.format("Persisted: %s\n", student));


    }
}
