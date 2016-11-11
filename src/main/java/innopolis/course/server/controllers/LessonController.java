package innopolis.course.server.controllers;

import innopolis.course.common.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Max Shalavin on 11.11.2016.
 */


@Controller
public class LessonController {

    @Autowired
    StudentService service;
    private static Logger logger = LoggerFactory.getLogger(innopolis.course.server.controllers.StudentController.class);

    /**
     * handle request "/" passes to JSP index.jsp list of Student
     *
     * @return modelAndView
     */
    @RequestMapping(value = "/lessons")
    public ModelAndView main(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("list", service.findAllStudent());
        modelAndView.setViewName("lessons");
        return modelAndView;
    }
}