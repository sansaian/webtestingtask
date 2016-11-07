package controllers;

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

    @RequestMapping(value = "/user")
    public ModelAndView search(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user");
        return modelAndView;
    }
//
//
//    /**
//     * @param id id student
//     * @return
//     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String delete(HttpServletRequest req) {

        return "redirect:/";
    }

//    /**
//     * show data about student who have this id
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
//    public ModelAndView view(/*HttpServletRequest req*/ @PathVariable Long id) {
//        logger.info("Show {}",id);
//        ModelAndView mv = new ModelAndView("form");
//        mv.addObject("student", studentService.getById(id));
//        return mv;
//    }
//
//    /**
//     * create model and view and call addform.jsp
//     *
//     * @param req
//     * @return
//     */
//    @RequestMapping(value = "/add")
//    public ModelAndView showAddForm(HttpServletRequest req) {
//        ModelAndView mv = new ModelAndView("addform");
//        if (req.getParameter("firstName") != null && !req.getParameter("firstName").equals("")) {
//            Student student = new Student(req);
//            studentService.add(student);
//        }
//        return mv;
//    }
//
//    /**
//     * Controller for Update data about Student
//     * @param req
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "student/{id}", method = RequestMethod.POST)
//    public ModelAndView update(HttpServletRequest req, @PathVariable Long id){
//        logger.info("Update {}",id);
//        ModelAndView mv = new ModelAndView("form");
//        Student student = new Student(req);
//        studentService.update(id,student);
//        mv.addObject("student", studentService.getById(id));
//        return mv;
//    }

}



