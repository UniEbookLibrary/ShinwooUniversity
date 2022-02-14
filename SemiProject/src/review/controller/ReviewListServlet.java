package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.PageInfo;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/reviewList.rv")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;		
		int currentPage;	
		int pageLimit;		
		int boardLimit;		
		int maxPage;		
		int startPage;		
		int endPage;		
		
		listCount = new ReviewService().getListCount();
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
		
			
		
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Review> list = new ReviewService().selectReviewList(pi);
		
		String page = null;
		
		if(list != null) {	//noticeList.jsp
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "WEB-INF/views/review/writelist.jsp";
		} else {			//errorPage.jsp
			request.setAttribute("msg", "오류");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
		//request.getRequestDispatcher("WEB-INF/views/review/writelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
