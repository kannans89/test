package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionController
 */
@WebServlet("/session")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session.getAttribute("x")==null)
			session.setAttribute("x", 0);
		out.println("<html><head></head><body>");
		out.println("<h1> old value:"+session.getAttribute("x")+"</h1>");
		session.setAttribute("x", (Integer)session.getAttribute("x")+1);
		out.println("<h1> New value:"+session.getAttribute("x")+"</h1>");
		out.println("<h2> Session id is" + session.getId()+"</h2>");
		out.println("</body></html>");
	}
	
}
