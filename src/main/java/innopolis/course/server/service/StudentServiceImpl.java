package innopolis.course.server.service;

import innopolis.course.common.service.StudentService;
import innopolis.course.server.dao.StudentDAOImpl;
import innopolis.course.server.dao.daointerfaces.StudentDAO;
import innopolis.course.server.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Max Shalavin on 08.11.2016.
 */
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDAO dao;

    @Override
    public boolean createnewStudent(HttpServletRequest req) {
        boolean result = false;
        Student student = dao.createStudent(req);
        if (student != null)
            result = true;
        return result;
    }

    @Override
    public void removeOldStudent(Long id) {
        if(id!=null &&id>=0)
        dao.removeStudent(id);
    }
    public Student findStudent(Long id) {
        if(id!=null &&id>0)
            return dao.findStudent(id);
        else
            return null;
    }


    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }

    @Override
    public Student changeStudent(HttpServletRequest reg,Long id) {
        String firstName =reg.getParameter("firstName");
        String lastName = reg.getParameter("lastName");
        Long studentId = id;
        return dao.changeStudent(studentId,firstName,lastName);
    }
//////////////////////////////////




}
