package reqBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.Member;
import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class RequestBookServlet
 */
@WebServlet("/request.bo")
public class RequestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String reqBookTitle = request.getParameter("bookTitle");
		String reqBookAuthor = request.getParameter("author");
		String reqBookPub = request.getParameter("publisher");
		String reqBookComment = request. getParameter("reqComment");
		String reqWriterId = ((Member)(request.getSession().getAttribute("loginUser"))).getMemberId();
		
		ReqBook r = new ReqBook();
		r.setReqBookTitle(reqBookTitle);
		r.setReqBookAuthor(reqBookAuthor);
		r.setReqBookPub(reqBookPub);
		r.setReqBookComment(reqBookComment);
		r.setReqWriterId(reqWriterId);
		
		int result = new ReqBookService().insertRequest(r);
		
		if(result > 0) {
			response.sendRedirect("myPage.me");
		} else {
			request.setAttribute("msg", "도서 신청 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
