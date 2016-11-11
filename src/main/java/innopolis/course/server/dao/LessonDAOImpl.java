package innopolis.course.server.dao;

import innopolis.course.server.dao.daointerfaces.LessonDAO;
import innopolis.course.server.entity.Lesson;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Max Shalavin on 11.11.2016.
 */
public class LessonDAOImpl implements LessonDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    @Override
    public Lesson createLesson(HttpServletRequest req) {
        transaction.begin();
        Lesson lesson = new Lesson();
        lesson.setTitle(req.getParameter("title"));
        em.persist(lesson);
        transaction.commit();
        return lesson;
    }

    @Override
    public void removeLesson(Long id) {
        Lesson lesson = em.find(Lesson.class, id);
        if (lesson != null) {
            transaction.begin();
            em.remove(lesson);
            transaction.commit();
        }
    }

    @Override
    public Lesson changeLesson(Long id, String title) {
        Lesson lesson = em.find(Lesson.class, id);

        if (lesson != null) {
            lesson.setTitle(title);
            em.merge(lesson);
        }
        return lesson;
    }

    @Override
    public Lesson findLesson(Long id) {
        Lesson lesson = em.find(Lesson.class, id);
        return lesson;
    }

    @Override
    public List<Lesson> findAllLesson() {
        TypedQuery<Lesson> query = em.createQuery("SELECT a FROM Lesson a", Lesson.class);
        return query.getResultList();
    }
}
