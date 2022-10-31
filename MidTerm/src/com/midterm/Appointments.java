package com.midterm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midterm.entities.Appointment;

/**
 * Servlet implementation class Appointments
 */
@WebServlet(value="/Appointments", loadOnStartup = 1)
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointments() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);    
    	
    	LocalDate date = LocalDate.of(2022, 10, 27);
		LocalTime time = LocalTime.parse("13:30");
		LocalDateTime localDateTime = LocalDateTime.of(date, time);
    	List<Appointment> appnts = new ArrayList<>();
    	Appointment appointment = new Appointment();
    	appointment.setName("John Doe");
    	appointment.setDepartment("Computers");
    	appointment.setStatus("Completed");
    	appointment.setAppTime(localDateTime);
    	appointment.setReason("Computer is not starting");
    	appnts.add(appointment);
    	appointment = new Appointment();
    	appointment.setName("Jane Doe");
    	appointment.setDepartment("Video games");
    	appointment.setStatus("Scheduled");
    	appointment.setReason("Not able to load game");
    	
    	appointment.setAppTime(localDateTime);
    	appnts.add(appointment);
    	
    	ServletContext servletContext = getServletContext();
        servletContext.setAttribute("appnts", appnts);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Appointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
