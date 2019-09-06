package com.learning;

import com.learning.command.Command;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Introductory extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/introductory/" , "");
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println(command.getClass().getName());
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request,response);
    }

    public void init(ServletConfig servletConfig) {
        UserService userService = new UserService();
//        servletConfig.getServletContext()
//                .setAttribute("loggedUsers", new HashSet<String>());
//        commands.put("login", new Login(userService));
//        commands.put("registration", new Registration(userService));
//        commands.put("logout", new LogOut());
//        commands.put("exception", new Exception());
//        commands.put("admin", new AdminRole());
//        commands.put("user", new UserRole());
//        commands.put("admin/userlist", new UserList(userService));

    }
}
