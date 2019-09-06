package com.learning.controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminRole implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals("ADMIN"))
            return "/WEB-INF/admin/adminbasic.jsp";
        else return "redirect:/";
    }
}

