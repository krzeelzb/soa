package ex3;

import ex3.models.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FeedbackServlet",urlPatterns = { "/ex3/sendFeedback" })
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("name");
        String email = request.getParameter("email");
        String comment = request.getParameter("comment");

        PrintWriter out = response.getWriter();

        ServletContext servletContext = getServletContext();

        Object posts=servletContext.getAttribute("listOfPosts");
        ArrayList<Post> postList =null;
        if (posts == null) {
            postList = new ArrayList<>();
        } else {
            postList = (ArrayList<Post>) posts;
        }
        postList.add(new Post(user,email,comment));

        out.println("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "  <meta charset=\"UTF-8\">\n"
                + "  <title>Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<form action=\"sendFeedback\" method=\"post\">\n"
                + "  Your name: <input type=\"text\" name=\"name\"/>\n"
                + "  Your email: <input type=\"text\" name=\"email\"/>\n"
                + "  Comment: <input type=\"text\" name=\"comment\"/>\n"
                + "  <input type=\"submit\" value=\"Send\"/>\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n");

        for(Post p:postList){
            out.println("user:"+p.user + "<br/> email: " + p.mail + "<br/> comment:" + p.comment + "<br/>");
        }

        servletContext.setAttribute("listOfPosts", postList);
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
