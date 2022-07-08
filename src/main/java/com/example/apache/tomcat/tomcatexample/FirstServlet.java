package com.example.apache.tomcat.tomcatexample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
Анотация WebServlet указывает с какой конечной точкой будет сопоставляться данный сервлет.
То есть данный сервлет будет обрабатывать запросы по адресу "/hello".
 */
@WebServlet(name = "hello", value = "/hello")
public class FirstServlet extends HttpServlet {

    /**
     * Для обработки GET-запросов(напрмер, при обращении к сервлету из адресной строки браузера)
     * сервлет должен переопределить метод {@link HttpServlet doGet}.
     * <p>Т.е. в данном случае GET-запрос по адресу /hello будет обрабатываться {@link HttpServlet doGet}.
     *
     * @param request параметр типа {@link jakarta.servlet.ServletRequest HttpServletRequest}
     *                инкапсулирует всю информацию о запросе.
     * @param response параметр типа {@link jakarta.servlet.ServletResponse HttpServletResponse}
     *                 позволяет управлять ответом. <p>В частности, с помощью
     *                 вызова response.setContentType("text/html") устанавливается тип
     *                 ответа(ответ представляет код html).
     *                 <p>С помощью метода {@link HttpServletResponse getWriter()} мы можем получить
     *                 объект {@link PrintWriter}, через который можно отправить
     *                 какой то определенный ответ пользователю(отправляем простой html-код).
     *                 <p>По завершению использования объекта {@link jakarta.servlet.ServletResponse HttpServletResponse}
     *                 его необходимо закрыть методом {@link java.io.Writer close}.
     */
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Hello from FirstServlet<h2>");
        } finally {
            writer.close();
        }
    }
}
