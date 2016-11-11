package innopolis.course.server.dao.daointerfaces;

import innopolis.course.server.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 10.11.2016.
 */
public interface StudentDAO {


    Student createStudent(HttpServletRequest req);

    void removeStudent(Long id) ;

    Student changeStudent(Long id, String firstname, String lastname);

    Student findStudent(Long id);

    List<Student> findAllStudent();
}
