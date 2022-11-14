package com.lab9.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab9.entities.Group;
import com.lab9.entities.Student;
import com.lab9.service.DbService;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var dbService = new DbService();
		request.setAttribute("groups", dbService.getGroupsForCreateStudent());
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/AddStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		Integer year = Integer.parseInt(request.getParameter("year"));
		String parentName = request.getParameter("parentName");
		String parentEmail = request.getParameter("parentEmail");
		String groupId = request.getParameter("group");
		var dbService = new DbService();
		dbService.addStudent(name, year, parentName, parentEmail, (groupId==null || groupId.equals("")) ? null: Integer.parseInt(groupId));
		dbService.close();

		response.sendRedirect( "StudentListServlet" );
	}
}
