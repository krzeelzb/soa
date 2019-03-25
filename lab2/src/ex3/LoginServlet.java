package ex3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "LoginServlet",urlPatterns = { "/ex3/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Vector<String> user = new Vector<String>();
    private final String userID = "admin";
    private final String password = "password";
    private final String name = "Jan";
    private final String surname = "Kowalski";


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        user.addElement(userID);
        user.addElement(password);
        user.addElement(name);
        user.addElement(surname);
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(userID.equals(user) && password.equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", name);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("LoginSuccess.jsp");
        }
        else if(user==null || user.length()==0)
            {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ex3/login.html");
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Enter login.</font>");
                rd.include(request, response);
            }

        else if(pwd==null || pwd.length()==0)
            {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ex3/login.html");
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Enter password</font>");
                rd.include(request, response);
            }

        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ex3/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }

    }

}