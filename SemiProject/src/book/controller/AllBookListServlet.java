package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;
import review.model.vo.PageInfo;

/**
 * Servlet implementation class AllBookListServlet
 */
@WebServlet("/ownBookList.li")
public class AllBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBookListServlet() {
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
		
		BookService bService = new BookService(); 
		listCount = bService.getListCount();
		
		currentPage = 1; 
		if(request.getParameter("currentPage") != null) { 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 20;
		
		if(request.getParameter("boardLimit") != null) { 
			boardLimit = Integer.parseInt(request.getParameter("boardLimit"));
		}
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit); 
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Book> list = bService.selectList(pi); // 게시글 가져오기
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/admin/adminBookList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "도서 목록 조회 실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
