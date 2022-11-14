package com.lab9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab9.entities.Group;
import com.lab9.entities.Student;
import com.lab9.service.DbService;

/**
 * Servlet implementation class EditGroup
 */
@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer groupId = Integer.parseInt(request.getParameter("group"));
		var dbService = new DbService();
		request.setAttribute("group", dbService.getGroup(groupId));
		dbService.close();
		
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var dbService = new DbService();
		dbService.editGroup(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		dbService.close();
		response.sendRedirect("GroupListServlet");
		
	}
	
	

}
