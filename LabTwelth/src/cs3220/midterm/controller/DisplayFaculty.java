package cs3220.midterm.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.midterm.model.Department;
import cs3220.midterm.service.DbService;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }



    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	var dbService = new DbService();
    	var depts = dbService.getDepartments();
    	dbService.close();
    	request.setAttribute("departments", depts);

        request.getRequestDispatcher( "/WEB-INF/midterm/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
