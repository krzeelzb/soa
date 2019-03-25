package ex2.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AgeServlet",urlPatterns = { "/ex2/age" })
public class AgeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAge = request.getParameter("age");
        System.out.print(userAge);

        if (Integer.parseInt(userAge)>=18){
            response.sendRedirect("ageSuccess.jsp");
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ex2/age.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Musisz mieć więcej niż 18 lat by przejść dalej</font>");
            rd.include(request, response);
        }

    }

}
