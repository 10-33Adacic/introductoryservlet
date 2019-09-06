package com.learning.controller.command;

import com.learning.model.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class EnrolleeRole implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Role role = (Role) request.getSession().getAttribute("role");
        if (role.equals(Role.USER))
            return "/WEB-INF/user/userbasic.jsp";
        else return "redirect:/";
    }
}
