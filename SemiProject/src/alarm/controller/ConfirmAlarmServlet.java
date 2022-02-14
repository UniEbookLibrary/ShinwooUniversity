package alarm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alarm.model.service.AlarmService;

/**
 * Servlet implementation class ConfirmAlarmServlet
 */
@WebServlet("/confirmAlarm.al")
public class ConfirmAlarmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmAlarmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int alarmNo = Integer.parseInt(request.getParameter("alarmNo"));
		
		int result = new AlarmService().confirmAlarm(alarmNo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
