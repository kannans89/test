package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Context")
public class ContextController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContextController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = request.getServletContext();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if (app.getAttribute("x") == null) {
			app.setAttribute("x", 0);
		}
		out.println("Old x" + app.getAttribute("x"));
		app.setAttribute("x", 1 + (Integer) app.getAttribute("x"));
		out.println("New x" + app.getAttribute("x"));

		out.println("</body></html>");

	}

}
