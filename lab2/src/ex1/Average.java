package ex1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Average",urlPatterns = { "/average" })
public class Average extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        int number3 = Integer.parseInt(request.getParameter("number3"));
        int number4 = Integer.parseInt(request.getParameter("number4"));
        int number5 = Integer.parseInt(request.getParameter("number5"));
        float average=(number1+number2+number3+number4+number5)/5;
        out.println("<html>");
        out.println("<head><title>ex1.Average</title></head>");
        out.println("<body>");
        out.println("<p>Średnia wynosi:  " +average+ "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
