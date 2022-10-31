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
		List<Student> students = (List<Student>) getServletContext().getAttribute("students");
		Student student = findStudent(id, students);
		Group group = student.getGroup();
		student.setGroup(null);
		group.getStudents().remove(student);
		response.sendRedirect("EditGroup?group="+groupId);
	}
	
	Student findStudent(Integer id, List<Student> students) {
		for(Student student: students) 
			if(id==student.getId()) 
				return student;
		return null;
	}
}
