package com.dodecahedron.lomonosov.controller;

import com.dodecahedron.lomonosov.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        UserBean user = new UserBean(request.getParameter("login"),request.getParameter("password"),request.getParameter("email"));
        PrintWriter out = response.getWriter();
        if(user.addUser()) {
            out.print("<h1>Congratulations!</h1>");
            out.print("<a href=\"/page/authorization.jsp\">Enter</a>");
        }
        else
            out.print("<h1>Something bad... May be you are already registered</h1>");


    }
}
