package com.techlabs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.model.Employee;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee(1, "Pankaj"));
		employees.add(new Employee(2, "Sachin"));
		
		request.setAttribute("EmployeeDetails", employees);
		RequestDispatcher nextPage=request.getRequestDispatcher("View/emp.jsp");
		nextPage.forward(request, response);
	}
}
