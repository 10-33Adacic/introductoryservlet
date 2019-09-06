package com.learning.controller.command;

import com.learning.model.entity.Enrollee;
import com.learning.model.entity.Role;
import com.learning.model.service.EnrolleeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class Login implements Command {
    private static final Logger logger = LogManager.getLogger(Login.class);
    private EnrolleeService enrolleeService;

    public Login(EnrolleeService enrolleeService) {
        this.enrolleeService = enrolleeService;
    }


    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //TODO refacror with optional
        if (email == null) return "/login.jsp";
        System.out.println("user enter email: "+ email + " " + password);

        System.out.println("entering DB : ");
        enrolleeService.findAllUsers().forEach(System.out::println);

        if (nonNull(request.getSession().getAttribute("userEmail"))) return "/welcome.jsp";

        Optional<Enrollee> user = enrolleeService.findUser(email, password);
        if (!user.isPresent()) {
            logger.info("Invalid attempt of user email: '" + email + "'");
            request.setAttribute("error", true);
            return "/login.jsp";
        }
        if (CommandUtility.checkUserIsLogged(request, email)) {
            logger.info("User email " + email + " already logged.");
            throw new RuntimeException("You already logged");
        }
        logger.info("User email " + email + " logged successfully.");

        if (user.get().getRole().equals(Role.ADMIN)) {
            CommandUtility.setUserRole(request, Role.ADMIN, email);
            return "redirect:/conference/admin";
        } else if (user.get().getRole().equals(Role.USER)) {
            CommandUtility.setUserRole(request, Role.USER, email);
            return "/WEB-INF/user/userbasic.jsp";
        } else {
            return "redirect:/index.jsp";
        }
    }
}
