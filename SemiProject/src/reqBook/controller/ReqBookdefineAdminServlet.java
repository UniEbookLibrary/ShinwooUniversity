package reqBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alarm.model.service.AlarmService;
import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class ReqBookdefineServelet
 */
@WebServlet("/reqBook.def")
public class ReqBookdefineAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqBookdefineAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int reqNo = Integer.parseInt(request.getParameter("reqNo")); 
		String reason = request.getParameter("reason");	
		String writer = request.getParameter("writer");
		String bookName = request.getParameter("bookName");
		
		int result3 = new ReqBookService().defineList(reqNo,reason);
		int result = new ReqBookService().insertReason(reqNo,reason);
		int result2 = new AlarmService().insertAlarm1(writer, bookName);
		
		
		String page = null;
		if(result > 0 && result2 > 0 && result3 > 0) {
			page = "WEB-INF/views/common/resultPage.jsp";
			request.setAttribute("msg", "신청이 거절되었습니다.");
		} else {
			page = "WEB-INF/views/common/resultPage.jsp";
			request.setAttribute("msg", "신청이 거절되었습니다.");
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
