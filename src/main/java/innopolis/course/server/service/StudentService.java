package innopolis.course.server.service;

import innopolis.course.server.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Max Shalavin on 08.11.2016.
 */
public class StudentService {
    private EntityManager em;

    public StudentService(EntityManager em) {
        this.em = em;
    }

    public Student createStudent(String firstName,String lastName,String sex) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setSex(sex);
        em.persist(student);
        return student;
    }

    public Student createStudent(HttpServletRequest req){
        Student student = new Student();
        student.setFirstName(req.getParameter("firstName"));
        student.setLastName(req.getParameter("lastName"));
        student.setSex(req.getParameter("sex"));
       // student.setBirth(req.getParameter("birth"));
        em.persist(student);
        return student;
    }
    public void removeArtist(int id) {
        Student student = em.find(Student.class, id);

        if (student != null) {
            em.remove(student);
        }
    }

    public Student changeStudent(int id, String name, String rock, String firstName, int i) {
        Student student = em.find(Student.class, id);

        if (student != null) {
            student.setFirstName(firstName);
        }

        return student;
    }

    public Student findStudent(int id) {
        return em.find(Student.class, id);
    }


    public List<Student> findAllStudent() {
        TypedQuery<Student> query = em.createQuery("SELECT a FROM Student a", Student.class);
        return query.getResultList();
    }
}