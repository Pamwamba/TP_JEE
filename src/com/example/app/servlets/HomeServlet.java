package com.example.app.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

    public HomeServlet() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the session and get the login variables
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        ServletContext application = this.getServletContext();
        RequestDispatcher rd;

        // get the user list if not null
        if(application.getAttribute("USERS") != null) {
            users.putAll((Map<? extends Integer, ? extends User>) application.getAttribute("USERS"));
        }
        // create the user list if the list is empty
        if(users.isEmpty()) {
            application.setAttribute("USERS", users);
        }
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

}
