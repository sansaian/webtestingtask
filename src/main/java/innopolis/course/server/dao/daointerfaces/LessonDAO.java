package innopolis.course.server.dao.daointerfaces;

import innopolis.course.server.entity.Lesson;
import innopolis.course.server.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Max Shalavin on 11.11.2016.
 */
public interface LessonDAO {

    Lesson createLesson(HttpServletRequest req);

    void removeLesson(Long id) ;

    Lesson changeLesson(Long id, String title);

    Lesson findLesson(Long id);

    List<Lesson> findAllLesson();
}
