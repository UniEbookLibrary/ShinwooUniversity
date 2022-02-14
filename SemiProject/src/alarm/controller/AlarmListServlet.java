package alarm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alarm.model.service.AlarmService;
import alarm.model.vo.Alarm;

/**
 * Servlet implementation class AlarmListServlet
 */
@WebServlet("/alarmList.al")
public class AlarmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlarmListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mId = request.getParameter("mId");
		
		ArrayList<Alarm> aList = new AlarmService().selectAlarm(mId);
		
		String page = null;
		
		if(aList != null) {	//noticeList.jsp
			request.setAttribute("aList", aList);
			page = "WEB-INF/views/alarm/alarmList.jsp";
		} else {			//errorPage.jsp
			request.setAttribute("msg", "오류");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
