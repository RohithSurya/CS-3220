package com.midterm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midterm.entities.Appointment;

/**
 * Servlet implementation class CompleteAppointment
 */
@WebServlet("/CompleteAppointment")
public class CompleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		List<Appointment> appointments = (List<Appointment>) getServletContext().getAttribute("appnts");
		Appointment appt = findAppt(id, appointments);
		appt.setStatus("Completed");
		response.sendRedirect("Appointments");
	}
	
	
	Appointment findAppt(Integer id, List<Appointment> appointments) {
		for(Appointment appointment: appointments) 
			if(id==appointment.getId()) 
				return appointment;
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}