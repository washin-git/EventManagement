package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.PackageDAOImpl;
import com.model.Package;
import com.data.PackageDAOImpl;
import com.model.Package;
/**
 * Servlet implementation class PackageController
 */
@WebServlet("/PackageController")
public class PackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	PackageDAOImpl packageUtil;
		
	String resource = "login1.jsp";
	String message = null;

	@Override
	public void init() throws ServletException {

		super.init();
		packageUtil = new PackageDAOImpl();
	}
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
				
			String COMMAND = request.getParameter("COMMAND");
			
			if(COMMAND == null) {
				COMMAND = "LIST";
			}
			
			switch(COMMAND) {
				
			case "LIST":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					listPackage(request, response);
				}
				break;
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addPackage(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deletePackage(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchPackage(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadPackage(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updatePackage(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkPackage(request,response);
				}
				break;
				
			default:
				listPackage(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void checkPackage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}


	private void sessionChecker(HttpServletRequest request, HttpServletResponse response) throws Exception {

		message = "Session Expired : TRY AGAIN";
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		request.setAttribute("msg", message);
		rd.forward(request, response);
	}
	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	doGet(request, response);
	
	//}
	
	private void loadPackage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id =Integer.parseInt(request.getParameter("id"));
		Package Package = packageUtil.getPackage(id);
		request.setAttribute("PACKAGE",Package);
		RequestDispatcher rd=request.getRequestDispatcher("UpdatePackage.jsp");
		rd.forward(request, response);
		
		
	}

	private void updatePackage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id =Integer.parseInt(request.getParameter("id"));
		String packageName=request.getParameter("packageName");
		double packagePrice=Double.parseDouble(request.getParameter("packagePrice"));
		String description=request.getParameter("description");
		double pricePerPerson=Double.parseDouble(request.getParameter("pricePerPerson"));
		
		
		Package packages =new Package(id,packageName, packagePrice, description, pricePerPerson);
		packageUtil.updatePackage(packages);
		
		listPackage(request,response);
	}


	private void SearchPackage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String packageName=request.getParameter("theSearchName");
		List<Package> packageList = packageUtil.searchPackage(packageName);
		request.setAttribute("PACKAGE_LIST", packageList);
		
		RequestDispatcher rd = request.getRequestDispatcher("packagelist.jsp");
		
		rd.forward(request, response);
		listPackage(request,response);
		
	}



	private void deletePackage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		packageUtil.deletePackage(id);
		listPackage(request,response);
		
	}


	private void addPackage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String packageName = request.getParameter("packageName");
		double packagePrice = Double.valueOf(request.getParameter("packagePrice"));
		String description = request.getParameter("description");
		double pricePerPerson = Double.valueOf(request.getParameter("pricePerPerson"));
	
	
		
		Package packages = new Package(packageName, packagePrice, description, pricePerPerson);
		
		packageUtil.addPackage(packages);
		
		response.sendRedirect("PackageController");
	}


	private void listPackage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Package> packageList = packageUtil.getPackage();
		request.setAttribute("PACKAGE_LIST", packageList);
		
		RequestDispatcher rd = request.getRequestDispatcher("packagelist.jsp");
		
		rd.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
