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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update/*")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<Integer, User> users = new HashMap<Integer, User>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        RequestDispatcher rd;
        // if login is not null, display home page, else, display login form
        if(login != null && !"".equals(login.trim())) {
            rd = this.getServletContext().getNamedDispatcher("JspUpdate");

        } else {
            rd = this.getServletContext().getNamedDispatcher("JspLogin");
            request.setAttribute("ERROR", "Not connected !");
        }

        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, User> users = new HashMap<Integer, User>();
        ServletContext application = this.getServletContext();
        users.putAll((Map<? extends Integer, ? extends User>) application.getAttribute("USERS"));

        Integer oneUser = Integer.parseInt(request.getParameter("id"));

        application.setAttribute("oneUser", (User) users.get(oneUser));
        doGet(request, response);
    }

}
