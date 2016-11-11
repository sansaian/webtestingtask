package innopolis.course.server.service;

import innopolis.course.common.service.LessonService;
import innopolis.course.server.dao.daointerfaces.LessonDAO;
import innopolis.course.server.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Max Shalavin on 11.11.2016.
 */
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonDAO dao;

    @Override
    public boolean createnewLesson(HttpServletRequest req) {
        boolean result = false;
        Lesson lesson = dao.createLesson(req);
        if (lesson != null)
            result = true;
        return result;
    }

    @Override
    public void removeOldLesson(Long id) {
        if(id!=null &&id>=0)
            dao.removeLesson(id);
    }
    public Lesson findLesson(Long id) {
        if(id!=null &&id>0)
            return dao.findLesson(id);
        else
            return null;
    }


    public List<Lesson> findAllLesson() {
        return dao.findAllLesson();
    }

    @Override
    public Lesson changeLesson(HttpServletRequest reg,Long id) {
        String title =reg.getParameter("title");
        Long studentId = id;
        return dao.changeLesson(id,title);
    }
}
