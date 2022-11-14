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
 * Servlet implementation class DeleteStudentGroup
 */
@WebServlet("/DeleteStudentGroup")
public class DeleteStudentGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("sid"));
		String groupId = request.getParameter("group");
		var dbService = new DbService();
		dbService.delelteStudentFromGroup(id);
		dbService.close();
		response.sendRedirect("EditGroup?group="+groupId);
	}
}
