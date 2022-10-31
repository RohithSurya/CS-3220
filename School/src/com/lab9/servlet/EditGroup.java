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
		List<Group> groups = (List<Group>)getServletContext().getAttribute("groups");
		Group group = getGroup(groupId, groups);
		request.setAttribute("group", group);
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer groupId = Integer.parseInt(request.getParameter("id"));
		List<Group> groups = (List<Group>)getServletContext().getAttribute("groups");
		Group group = getGroup(groupId, groups);
		group.setName(request.getParameter("name"));
		response.sendRedirect("GroupListServlet");
		
	}
	
	Student findStudent(Integer id, List<Student> students) {
		for(Student student: students) 
			if(id==student.getId()) 
				return student;
		return null;
	}
	
	Group getGroup(Integer id, List<Group> groups) {
		for(Group group: groups) {
			if(group.getId()==id) return group;
		}
		return null;
	}
	
	

}
