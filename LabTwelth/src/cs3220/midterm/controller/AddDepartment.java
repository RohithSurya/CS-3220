package cs3220.midterm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.midterm.model.Department;
import cs3220.midterm.service.DbService;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/midterm/AddDepartment.jsp" )
            .forward( request, response );;
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	var dbService = new DbService();
    	dbService.addDepartment((String)request.getParameter("name"));
    	dbService.close();
        response.sendRedirect( "DisplayFaculty" );
    }

}
