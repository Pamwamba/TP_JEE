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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete/*")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Map<Integer, User> users = new HashMap<Integer, User>();
        users.putAll((Map<? extends Integer, ? extends User>) application.getAttribute("USERS"));
        users.remove(id);
        application.setAttribute("USERS", users);
        response.sendRedirect("/TP_JEE/home");
    }

}
