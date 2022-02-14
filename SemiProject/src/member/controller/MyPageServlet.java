package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookRental.model.service.BookRentalService;
import bookRental.model.vo.BookRental;
import member.vo.Member;
import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		ArrayList<ReqBook> list = new ReqBookService().selectMyList(loginUser.getMemberId());
		
		ArrayList<BookRental> rentalList = new BookRentalService().selectMyRental(loginUser.getMemberId());
		
		String page = null;
		
		if(list != null) {	//noticeList.jsp
			request.setAttribute("list", list);
			request.setAttribute("rentalList", rentalList);
			page = "WEB-INF/views/member/mypage.jsp";
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
