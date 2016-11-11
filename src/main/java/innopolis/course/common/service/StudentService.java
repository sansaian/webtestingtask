package innopolis.course.common.service;

import innopolis.course.server.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 10.11.2016.
 */
public interface StudentService {


    boolean createnewStudent(HttpServletRequest req);

     void removeOldStudent(Long id);

    Student changeStudent(HttpServletRequest reg,Long id);

    Student findStudent(Long id);

    List<Student> findAllStudent();

}
