package com.learning.controller.command;

import com.learning.model.service.EnrolleeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Registration implements Command {
    private static final Logger logger = LogManager.getLogger(Login.class);
    private EnrolleeService enrolleeService;

    public Registration(EnrolleeService enrolleeService) {
        this.enrolleeService = enrolleeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null) return "/registration.jsp";
        try {
            enrolleeService.addUser(name, email, password);
            logger.info("Registration enrollee's email " + email + " successfully.");
        } catch (SQLException e) {
            request.setAttribute("error", true);
        }
        return "/registration.jsp";
    }
}
