package com.dodecahedron.lomonosov.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.dodecahedron.lomonosov.model.UserBean;
@WebServlet("/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        UserBean user = new UserBean(request.getParameter("login"),request.getParameter("password")); // инициализируем юзера данными, которые пришли со страницы
        if(user.logIn()){ //проверяем, есть ли такая учетная запись
            HttpSession session = request.getSession();
            session.setAttribute("userId",user.getId());
            session.setAttribute("login",user.getLogin()); //конструктор для регистрации
            session.setAttribute("email",user.getEmail());
            response.sendRedirect("/page/home.jsp");

        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<h1>Wrong login or password</h1>");
        }


    }
}

