package innopolis.course.server.controllers;

import innopolis.course.server.entity.Student;
import innopolis.course.server.service.StudentService;
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

    //заменить на autowired
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
        modelAndView.addObject("list", service.findAllStudent());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/list")
    public ModelAndView search(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/user/list")
    public ModelAndView delete(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "admin/add")
    public ModelAndView showAddForm(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("addform");
        return mv;
    }

    @RequestMapping(value = "admin/add/addform")
    public ModelAndView AddStudent(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("addform");
        if (req.getParameter("firstName") != null && !req.getParameter("firstName").equals("")) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            service.createStudent(req);
           // Student student = service.createStudent("Bob","Shaasdasdasd","male");
            transaction.commit();
            req.setAttribute("msg", "Student is add");
        }
        else
        {
            req.setAttribute("msg", "please,fill in the form");
        }
        return mv;
    }
}



