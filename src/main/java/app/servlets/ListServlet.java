package app.servlets;

import app.model.Model;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "list", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        Model model = Model.getInstance();
        List<String> names = model.list();
        request.setAttribute("userNames", names);

        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
