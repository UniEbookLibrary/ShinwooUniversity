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
 * Servlet implementation class ReqBookServlet
 */
@WebServlet("/reqBook.confi")
public class ReqBookConfirmAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqBookConfirmAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reqNo = Integer.parseInt(request.getParameter("reqNo")); 
		String writer = request.getParameter("writer");
		String bookName = request.getParameter("bookName");
		
		int result1 = new ReqBookService().confirmList(reqNo);
		
		int result2 = new AlarmService().insertAlarm2(writer,bookName);
		
		String page = null;
		if(result1 > 0 && result2 > 0) {
			page = "WEB-INF/views/common/resultPage.jsp";
			request.setAttribute("msg", "신청이 승인되었습니다.");
		} else {
			page = "WEB-INF/views/common/resultPage.jsp";
			request.setAttribute("msg", " 승인 실패되셨습니다.");
			
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
