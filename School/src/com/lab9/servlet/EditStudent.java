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
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var dbService = new DbService();
		var student = dbService.getStudent(Integer.parseInt(request.getParameter("edit")));
		request.setAttribute("groups", dbService.getGroupsForEditStudent(student.getGroup()!=null ? student.getGroup().getId() : null));
		request.setAttribute("student", student);
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String groupObj = request.getParameter("group");
		Integer groupId = (groupObj==null || groupObj.equals("")) ? null: Integer.parseInt(groupObj);
		var dbService = new DbService();
		dbService.editStudent(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), Integer.parseInt(request.getParameter("year")), request.getParameter("parentName"), request.getParameter("parentEmail"), groupId);
		dbService.close();
		
		response.sendRedirect( "StudentListServlet" );
	}
	
	

}
