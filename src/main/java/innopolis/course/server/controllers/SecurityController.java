package innopolis.course.server.controllers;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class SecurityController {

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req,@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        if (error != null) {
            model.addAttribute("error", "Wrong password or login!");
        }
        if (logout != null) {
            model.addAttribute("msg", "all right");
        }

//        String role = "ROLE_ADMIN";
//        Object s =new SecurityContextHolderAwareRequestWrapper(req, "role");
//        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
//                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//
//        boolean hasRole = false;
//        for (GrantedAuthority authority : authorities) {
//            String role = authority.getAuthority();
//        }
return "login";
    }
}