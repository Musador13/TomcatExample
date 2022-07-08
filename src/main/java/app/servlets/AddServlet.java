package app.servlets;

import app.entities.User;
import app.model.Model;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

//@WebServlet(name = "add", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        User user = new User(name, password);
        Model model = Model.getInstance();
        model.add(user);

        request.setAttribute("userName", name);
        doGet(request, response);
    }
}
