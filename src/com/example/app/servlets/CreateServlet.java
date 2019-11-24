package com.example.app.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the form to create an user
        ServletContext application = this.getServletContext();
        Integer id = Integer.parseInt(request.getParameter("id"));
        application.setAttribute("newUserId", id);
        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("JspCreate");
        rd.forward(request, response);
    }

}
