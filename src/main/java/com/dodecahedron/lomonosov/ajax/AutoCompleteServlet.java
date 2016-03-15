package com.dodecahedron.lomonosov.ajax;

import com.dodecahedron.lomonosov.connection.DBWorker;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daria on 04.05.2015.
 */
@WebServlet("/autocomplete")
public class AutoCompleteServlet extends HttpServlet {
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = "complete";
        String targetId = req.getParameter("id") + "%";
        StringBuffer sb = new StringBuffer();
        String str;
        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        }


        boolean namesAdded = false;
        if (action.equals("complete")) {
            final String searchResult = "SELECT email FROM lomonosov.users WHERE email LIKE ? OR login LIKE ?";
            DBWorker worker = new DBWorker();
            try {
                PreparedStatement preparedStatement = worker.getConnection().prepareStatement(searchResult);
                preparedStatement.setString(1, targetId);
                preparedStatement.setString(2, targetId);
                ResultSet res = preparedStatement.executeQuery(); //���������� ������
                while (res.next()) {
                    sb.append("<user>");
                    sb.append("<email>" + res.getString("email") + "</email>");
                    sb.append("</user>");
                    namesAdded = true;
                }
                worker.getConnection().close();//��������� connection//
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (namesAdded) {
            resp.setContentType("text/xml");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<users>" + sb.toString() + "</users>");
        } else {
            //nothing to show
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        }
    }
}
