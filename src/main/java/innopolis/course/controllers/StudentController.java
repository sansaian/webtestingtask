package innopolis.course.controllers;

import innopolis.course.entity.Student;
import innopolis.course.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

/**
 * StudentController Servlet for work with JSP
 */
@Controller
public class StudentController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
    EntityManager em = emf.createEntityManager();
    StudentService service = new StudentService(em);


    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    /**
     * handle request "/" passes to JSP index.jsp list of Student
     *
     * @return modelAndView
     */
    @RequestMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView search(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("--- Create and persist artist ---");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Student student = service.createStudent(10,"Max","Shalavin","m");

        transaction.commit();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/user")
    public ModelAndView delete(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user");
        return modelAndView;
    }
}



