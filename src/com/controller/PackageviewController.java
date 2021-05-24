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


import com.data.PackageviewDAOImpl;
import com.model.Packageview;



/**
 * Servlet implementation class PackageviewController
 */
@WebServlet("/PackageviewController")
public class PackageviewController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	
	PackageviewDAOImpl packageviewUtil;
		
	String resource = "login1.jsp";
	String message = null;

	@Override
	public void init() throws ServletException {

		super.init();
		packageviewUtil = new PackageviewDAOImpl();
	}
    public PackageviewController() {
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
					listPackageview(request, response);
				}
				break;
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addPackageview(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deletePackageview(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchPackageview(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadPackageview(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updatePackageview(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkPackageview(request,response);
				}
				break;
				
			default:
				listPackageview(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void checkPackageview(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
	
	private void loadPackageview(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id =Integer.parseInt(request.getParameter("id"));
		Packageview Packageview = packageviewUtil.getPackageview(id);
		request.setAttribute("PACKAGEVIEW",Packageview);
		RequestDispatcher rd=request.getRequestDispatcher("UserViewPackage.jsp");
		rd.forward(request, response);
		
		
	}

	private void updatePackageview(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id =Integer.parseInt(request.getParameter("id"));
		String packageName=request.getParameter("packageName");
		double packagePrice=Double.parseDouble(request.getParameter("packagePrice"));
		String description=request.getParameter("description");
		double pricePerPerson=Double.parseDouble(request.getParameter("pricePerPerson"));
		
		
		Packageview packagesview =new Packageview(id,packageName, packagePrice, description, pricePerPerson);
		packageviewUtil.updatePackageview(packagesview);
		
		listPackageview(request,response);
	}


	private void SearchPackageview(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String packageName=request.getParameter("theSearchName");
		List<Packageview> packageviewList = packageviewUtil.searchPackageview(packageName);
		request.setAttribute("PACKAGEVIEW_LIST", packageviewList);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserViewPackage.jsp");
		
		rd.forward(request, response);
		listPackageview(request,response);
		
	}



	private void deletePackageview(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		packageviewUtil.deletePackageview(id);
		listPackageview(request,response);
		
	}


	private void addPackageview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String packageName = request.getParameter("packageName");
		double packagePrice = Double.valueOf(request.getParameter("packagePrice"));
		String description = request.getParameter("description");
		double pricePerPerson = Double.valueOf(request.getParameter("pricePerPerson"));
	
	
		
		Packageview packagesview = new Packageview(packageName, packagePrice, description, pricePerPerson);
		
		packageviewUtil.addPackageview(packagesview);
		
		response.sendRedirect("PackageviewController");
	}


	private void listPackageview(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Packageview> packageviewList = packageviewUtil.getPackageview();
		request.setAttribute("PACKAGEVIEW_LIST", packageviewList);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserViewPackage.jsp");
		
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
