package ex1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "OrderInt",urlPatterns = { "/orderInt" })
public class OrderInt extends HttpServlet {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            PrintWriter out=response.getWriter();
            response.setContentType("text/html");

            Enumeration en=request.getParameterNames();
            List<Integer> listInteger=new ArrayList<>();

            while(en.hasMoreElements())
            {
                Object objOri=en.nextElement();
                String param=(String)objOri;

                String value=request.getParameter(param);
                if(isInteger(value)){
                    listInteger.add(Integer.parseInt(value));
                }
                else{
                    out.println("<html>");
                    out.println("<head><title>ex1.Average</title></head>");
                    out.println("<body>");
                    out.println("Bad input - not an integer");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();
                }

            }
            Collections.sort(listInteger);
            out.println("<html>");
            out.println("<head><title>ex1.Average</title></head>");
            out.println("<body>");
            for(int i:listInteger){
                out.println(i);
            }
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
