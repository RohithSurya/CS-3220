package cs3220.midterm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.midterm.model.Department;
import cs3220.midterm.model.Faculty;
import cs3220.midterm.service.DbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	var dbService = new DbService();
    	request.setAttribute("departments", dbService.getDepartments());
    	dbService.close();
        request.getRequestDispatcher( "/WEB-INF/midterm/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        var deptId = Integer.parseInt(request.getParameter( "department" ));
        var name = request.getParameter( "faculty" );
        System.out.println(request.getParameter("chair"));
        var isChair = "on".equals(request.getParameter("chair")) ? 1 : 0;
        var dbService = new DbService();
        dbService.addFaculty(name, isChair, deptId);
        dbService.close();
        response.sendRedirect( "DisplayFaculty" );
    }

}
