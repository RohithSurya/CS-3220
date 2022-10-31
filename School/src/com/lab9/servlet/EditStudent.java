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
		Integer id = Integer.parseInt(request.getParameter("edit"));
		List<Student> students = (List<Student>) getServletContext().getAttribute("students");
		request.setAttribute("student", findStudent(id, students));
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
	}
	
	
	Student findStudent(Integer id, List<Student> students) {
		for(Student student: students) 
			if(id==student.getId()) 
				return student;
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> students = (List<Student>) getServletContext().getAttribute("students");
		List<Group> groups = (List<Group>)getServletContext().getAttribute("groups");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Student student = findStudent(id, students);
		Group oldGroup = student.getGroup();
		student.setName(request.getParameter("name"));
		student.setYear(Integer.parseInt(request.getParameter("year")));
		student.setParent(request.getParameter("parentName"));
		student.setEmail(request.getParameter("parentEmail"));
		String groupId = request.getParameter("group");
		Group newGroup = (groupId==null || groupId.equals("")) ? null: getGroup(Integer.parseInt(groupId), groups);
		if(newGroup!=oldGroup) {
			student.setGroup(newGroup);
			if(oldGroup!=null)
				oldGroup.getStudents().remove(student);
			if(newGroup!=null)
				newGroup.getStudents().add(student);
		}

		response.sendRedirect( "StudentListServlet" );
	}
	
	Group getGroup(Integer id, List<Group> groups) {
		for(Group group: groups) {
			if(group.getId()==id) return group;
		}
		return null;
	}
	
	

}
