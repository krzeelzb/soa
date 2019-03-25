package ex2.controllers;

import ex2.models.ExpertBeer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChoiceBeerServlet",urlPatterns = { "/ex2/choiceBeerServlet" })
public class ChoiceBeerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String beer = request.getParameter("beerColor");
        String beerBrand=chosenBeer(beer).toString();
        PrintWriter out = response.getWriter();


            Cookie beerToShow = new Cookie("beerColor", beerBrand);


            response.addCookie(beerToShow);
            response.sendRedirect("wynik.jsp");

        out.write(beer);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    ExpertBeer chosenBeer(String color){
        if(color.equals("jasne")) return ExpertBeer.LECH;
        else  if(color.equals("biale")) return ExpertBeer.IPA;
        else  if(color.equals("ciemne")) return ExpertBeer.TATRA;
        return ExpertBeer.JUICE;
    }
}
