import innopolis.course.server.dao.StudentDAOImpl;
import innopolis.course.server.entity.Student;
import innopolis.course.server.service.StudentServiceImpl;

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
        StudentDAOImpl dao = new StudentDAOImpl();

        System.out.println("--- Create and persist artist ---");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
//        Student student = dao.createStudent("Sadasd","Shalavin","m");
        Long l = Long.valueOf(20);
        transaction.commit();
        System.out.println(String.format("Persisted: %s\n", "ss" +   dao.findStudent(l)));


    }
}
