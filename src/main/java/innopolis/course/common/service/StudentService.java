package innopolis.course.common.service;

import innopolis.course.server.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 10.11.2016.
 */
public interface StudentService {


    boolean createStudent(HttpServletRequest req);

     void removeStudent(Long id);

    Student changeStudent(Long id, String firstName, String lastName, String sex, Date birth);

    Student findStudent(Long id);

    List<Student> findAllStudent();

}
