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

    @RequestMapping(value = "/admin")
    public ModelAndView search(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

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



