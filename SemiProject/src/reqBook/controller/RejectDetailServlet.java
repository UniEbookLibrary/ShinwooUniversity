package reqBook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class RejectDetailServlet
 */
@WebServlet("/rejectDetail.rb")
public class RejectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		ReqBook rb = new ReqBookService().getReject(rno);
		
		
		String page = null;
		
		if(rb != null) {	//noticeList.jsp
			request.setAttribute("rb", rb);
			page = "WEB-INF/views/reqBook/rejectDetail.jsp";
		} else {			//errorPage.jsp
			request.setAttribute("msg", "공지사항 조회 실패");
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
