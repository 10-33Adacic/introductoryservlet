package com.learning.controller.command;

import com.learning.model.service.EnrolleeService;

import javax.servlet.http.HttpServletRequest;

public class EnrolleeList implements Command {
    private EnrolleeService enrolleeService;

    public EnrolleeList(EnrolleeService enrolleeService) {
        this.enrolleeService = enrolleeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("enrolleeList", enrolleeService.findAllUsers());
        return "/WEB-INF/admin/enrolleelist.jsp";
    }
}
