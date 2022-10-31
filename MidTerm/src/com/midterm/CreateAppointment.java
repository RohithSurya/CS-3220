package com.midterm;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midterm.entities.Appointment;

/**
 * Servlet implementation class CreateAppointment
 */
@WebServlet("/CreateAppointment")
public class CreateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/CreateAppointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String apptTime = request.getParameter("apptTime");
		String[] departments= request.getParameterValues("departments");
		String reason = request.getParameter("reason");
		List<Appointment> appnts = (List<Appointment>) getServletContext().getAttribute("appnts");
		for(String department: departments) {
			LocalDate date = LocalDate.of(2022, 10, 27);
			LocalTime time = LocalTime.parse(apptTime);
			LocalDateTime localDateTime = LocalDateTime.of(date, time);
			Appointment appointment = new Appointment(localDateTime, name, department, "Scheduled", reason);
			appnts.add(appointment);
		}
		
		response.sendRedirect("Appointments");
		
		
	}

}
