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
		Group group = (groupId==null || groupId.equals("")) ? null: getGroup(Integer.parseInt(groupId));
		Student student = new Student(name, year, parentName , parentEmail, group);
		if(group!=null) {
			group.getStudents().add(student);
			student.setGroup(group);
		}
		List<Student> students = (List<Student>) getServletContext().getAttribute("students");
		students.add(student);

		response.sendRedirect( "StudentListServlet" );
	}
	
	Group getGroup(Integer id) {
		List<Group> groups = (List<Group>)getServletContext().getAttribute("groups");
		for(Group group: groups) {
			if(group.getId()==id) return group;
		}
		return null;
	}
}
