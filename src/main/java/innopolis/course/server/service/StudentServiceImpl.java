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
//    private EntityManager em;

    StudentDAO dao= new StudentDAOImpl();

    @Override
    public boolean createStudent(HttpServletRequest req) {
        boolean result = false;
        Student student = dao.createStudent(req);
        if (student != null)
            result = true;
        return result;
    }

    @Override
    public void removeStudent(Long id) {
        if(id!=null &&id>=0)
        dao.removeStudent(id);
    }
//////////////////////////////
    @Override
    public Student changeStudent(Long id, String name, String sex, String firstName, Date birth) {

        return dao.changeStudent(id,name,sex,firstName,birth);
    }
//////////////////////////////////
    public Student findStudent(Long id) {
        if(id!=null &&id<0)
        return dao.findStudent(id);
        else
            return null;
    }


    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }
}
