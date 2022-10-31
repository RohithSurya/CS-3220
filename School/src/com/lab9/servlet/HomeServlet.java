package com.lab9.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab9.entities.Group;
import com.lab9.entities.Student;

@WebServlet(urlPatterns = {"/HomeServlet"}, loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	List<Group> groups = new ArrayList<>();
    	Group group = new Group();
    	group.setName("Avengers");
    	List<Student> gStudents = new ArrayList<Student>();
    	Student student = new Student("Akash", 2001, "Tatina", "akash@calstatela.edu", group);
    	gStudents.add(student);
    	group.setStudents(gStudents);
    	groups.add(group);
    	List<Student> students = new ArrayList<>();
        students.add(student);
        student = new Student("Sagar", 2000, "Addala", "sagar@calstatela.edu", group);
        gStudents.add(student);
        group.setStudents(gStudents);
        students.add(student);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("students", students);
        servletContext.setAttribute("groups", groups);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/HomeServlet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
