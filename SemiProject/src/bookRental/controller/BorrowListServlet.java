package bookRental.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookRental.model.service.BookRentalService;
import bookRental.model.vo.BookRental;
import member.vo.Member;
import review.model.vo.PageInfo;

/**
 * Servlet implementation class BorrowListServlet
 */
@WebServlet("/borrowList.br")
public class BorrowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = ((Member)request.getSession().getAttribute("loginUser")).getMemberId();
		
		int listCount;		
		int currentPage;	
		int pageLimit;		
		int boardLimit;		
		int maxPage;		
		int startPage;		
		int endPage;
		
		listCount = new BookRentalService().getListCount(user);
		System.out.println("listCount : " + listCount);
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("currentPage : " +currentPage);
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		System.out.println("maxPage : " + maxPage);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		System.out.println(pi);
		
		ArrayList<BookRental> list = new BookRentalService().selectRentalList(pi, user);
		
		String page = null;
		
		if(list != null) {	//noticeList.jsp
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "WEB-INF/views/bookRental/userRentList.jsp";
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
