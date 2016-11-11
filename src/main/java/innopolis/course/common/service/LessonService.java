package innopolis.course.common.service;

import innopolis.course.server.entity.Lesson;
import innopolis.course.server.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Max Shalavin on 11.11.2016.
 */
public interface LessonService {

    boolean createnewLesson(HttpServletRequest req);

    void removeOldLesson(Long id);

    Lesson changeLesson(HttpServletRequest reg, Long id);

    Lesson findLesson(Long id);

    List<Lesson> findAllLesson();
}
