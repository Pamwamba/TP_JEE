package com.example.app.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.entities.User;

/**
 * Servlet implementation class JspHomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<Integer, User> users = new HashMap<Integer, User>();

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public HomeServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the session and get the login variable
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        ServletContext application = this.getServletContext();
        RequestDispatcher rd;
        users.putAll(initUsers());
        application.setAttribute("USERS", users);
        // if login is not null, display home page, else, display login form
        if(login != null && !"".equals(login.trim())) {
            rd = this.getServletContext().getNamedDispatcher("JspHome");

        } else {
            rd = this.getServletContext().getNamedDispatcher("JspLogin");
            request.setAttribute("ERROR", "Not connected !");
        }

        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    private Map<Integer, User> initUsers() {

        Map<Integer, User> users = new HashMap<Integer, User>();

        User user01 = new User(1, "Pamwamba", "Samy", "Moussaoui", "4 rue des Erables", "0652561932", "", "samy@ovg.com", "pamwamba");
        User user02 = new User(2, "Ninja", "John", "Snow", "12 rue des Erables", "0652561932", "", "john@ovg.com", "ninja");
        User user03 = new User(3, "Zizou", "Zinedine", "Zidane", "42 rue des Erables", "0652561932", "", "zinedine@ovg.com", "zizou");
        User user04 = new User(4, "Norul", "Edward", "Albert", "74 rue des Erables", "0652561932", "", "edward@ovg.com", "norul");
        User user05 = new User(5, "Falfir", "Jean", "Neymar", "41 rue des Erables", "0652561932", "", "jean@ovg.com", "falfir");
        User user06 = new User(6, "Norcar", "Orni", "Car", "5 rue des Erables", "0652561932", "", "orni@ovg.com", "norcar");
        User user07 = new User(7, "Tirgil", "Timothée", "Smith", "55 rue des Erables", "0652561932", "", "timothee@ovg.com", "tirgil");
        User user08 = new User(8, "Uiryn", "Sam", "Frodon", "423 rue des Erables", "0652561932", "", "sam@ovg.com", "uiryn");
        User user09 = new User(9, "Gwerharim", "Gwen", "Hakim", "9 rue des Erables", "0652561932", "", "gwen@ovg.com", "gwerharim");
        User user10 = new User(10, "Filnag", "Phillipe", "Nagui", "788 rue des Erables", "0652561932", "", "phillipe@ovg.com", "filnag");
        User user11 = new User(11, "Onmoe", "Oni", "Moe", "1245 rue des Erables", "0652561932", "", "oni@ovg.com", "onmoe");
        User user12 = new User(12, "Cergal", "Cergal", "Lagrec", "546 rue des Erables", "0652561932", "", "cergal@ovg.com", "cergal");
        User user13 = new User(13, "Ilthon", "Ilsaumon", "Delamer", "578 rue des Erables", "0652561932", "", "ilsaumon@ovg.com", "ilthon");
        users.put(1, user01);
        users.put(2, user02);
        users.put(3, user03);
        users.put(4, user04);
        users.put(5, user05);
        users.put(6, user06);
        users.put(7, user07);
        users.put(8, user08);
        users.put(9, user09);
        users.put(10, user10);
        users.put(11, user11);
        users.put(12, user12);
        users.put(13, user13);

        return users;
    }

}
