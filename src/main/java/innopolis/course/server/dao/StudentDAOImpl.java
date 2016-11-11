package innopolis.course.server.dao;

import innopolis.course.server.dao.daointerfaces.StudentDAO;
import innopolis.course.server.entity.Student;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 10.11.2016.
 */
public class StudentDAOImpl implements StudentDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    @Override
    public Student createStudent(HttpServletRequest req) {

        transaction.begin();
        Student student = new Student();
        student.setFirstName(req.getParameter("firstName"));
        student.setLastName(req.getParameter("lastName"));
        student.setSex(req.getParameter("sex"));
        // student.setBirth(req.getParameter("birth"));
        em.persist(student);
        transaction.commit();
        return student;
    }

    @Override
    public void removeStudent(Long id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            transaction.begin();
            em.remove(student);
            transaction.commit();

        }
    }

    @Override
    public Student changeStudent(Long id, String firstname, String lastname, String sex, Date birth) {
        Student student = em.find(Student.class, id);

        if (student != null) {
            student.setFirstName(firstname);
            student.setLastName(lastname);
            student.setSex(sex);
            student.setBirth(birth);
        }

        return student;
    }

    @Override
    public Student findStudent(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudent() {
        TypedQuery<Student> query = em.createQuery("SELECT a FROM Student a", Student.class);
        return query.getResultList();
    }
}
