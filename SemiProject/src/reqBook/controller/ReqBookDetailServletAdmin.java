package reqBook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class ReqBookDetail
 */
@WebServlet("/reqBook.de")
public class ReqBookDetailServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqBookDetailServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reqNo = Integer.parseInt(request.getParameter("reqNo")); 
				
		ReqBook r = new ReqBookService().sendReqinfo(reqNo);
		
		String page = null;
		if(r != null) {
			page = "WEB-INF/views/reqBook/reqBookResultAdmin.jsp";
			request.setAttribute("r", r);
		} else {
			page = "WEB-INF/views/common/errorPage2.jsp";
			request.setAttribute("msg", "신청도서 상태 변경 실패");
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
