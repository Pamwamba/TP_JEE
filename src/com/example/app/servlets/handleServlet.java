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

import com.example.app.entities.User;

/**
 * Servlet implementation class handleServlet
 */
/**
 * @author Samy
 * This servlet is used for creating and updating an user
 *
 */
@WebServlet("/handle/*")
public class handleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to home page
        response.sendRedirect("/TP_JEE/home");

    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, User> users = new HashMap<Integer, User>();
        ServletContext application = this.getServletContext();
        RequestDispatcher rd;
        // get the id of the user (created or not)
        Integer key = Integer.parseInt(request.getParameter("id"));

        // get the user list
        users.putAll((Map<? extends Integer, ? extends User>) application.getAttribute("USERS"));

        User u = new User();
        // set all informations
        u.setId(key);
        u.setUsername(request.getParameter("username").toString());
        u.setFirstname(request.getParameter("firstname").toString());
        u.setLastname(request.getParameter("lastname").toString());
        u.setAddress(request.getParameter("address").toString());
        u.setPhone(request.getParameter("phone").toString());
        u.setEmail(request.getParameter("mail").toString());
        // set a default avatar if the field is blank
        if (request.getParameter("avatar") == "" ) {
            u.setPhoto("/TP_JEE/img/default.jpg");
        } else {
            u.setPhoto(request.getParameter("avatar").toString());
        }
        // if the key exists, it means that this is an update
        if (users.containsKey(key)) {
            // replace the user in the HashMap
            users.replace(key , u);
            application.setAttribute("USERS", users);
            rd = this.getServletContext().getNamedDispatcher("JspHome");
            response.sendRedirect("/TP_JEE/home");
        } else {
            // else, create the user then go to the profile
            users.put(key, u);
            application.setAttribute("USERS", users);
            rd = this.getServletContext().getNamedDispatcher("JspShow");
            response.sendRedirect("/TP_JEE/show/" + key);
        }

    }

}
