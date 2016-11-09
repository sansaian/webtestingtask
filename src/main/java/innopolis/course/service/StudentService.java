package innopolis.course.service;

import innopolis.course.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 08.11.2016.
 */
public class StudentService {
    private EntityManager em;

    public StudentService(EntityManager em) {
        this.em = em;
    }

    public Student createStudent(int id, String firstName,String lastName,String sex) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setSex(sex);
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
