package com.learning.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index.jsp";
    }
}
