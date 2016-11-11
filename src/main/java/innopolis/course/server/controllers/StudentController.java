package innopolis.course.server.controllers;

import innopolis.course.common.service.StudentService;
import innopolis.course.server.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

/**
 * StudentController Servlet for work with JSP
 */
@Controller
public class StudentController {


    //заменить на autowired
    StudentService service = new StudentServiceImpl();


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
            service.createStudent(req);
            req.setAttribute("msg", "Student is add");
        }
        else
        {
            req.setAttribute("msg", "please,fill in the form");
        }
        return mv;
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        service.removeStudent(id);
       logger.info("Delete {}",id);
        return "redirect:/";
    }
}



