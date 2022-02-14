package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.vo.Book;
import review.model.vo.PageInfo;
import search.model.service.SearchService;

/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/searchBook.sr")
public class SearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryNo = 0;
		if(request.getParameter("categoryNo") != null) {
			categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		}
		
		String category = null;
		String kword = null;
		if(request.getParameter("category") != null) {
			category = request.getParameter("category");
			kword = request.getParameter("kword");
		}
		
		ArrayList<Book> bList = null;
		
		
		int listCount;		
		int currentPage;	
		int pageLimit;		
		int boardLimit;		
		int maxPage;		
		int startPage;		
		int endPage;	
		
		if(categoryNo == 0) {		//클릭을 안한상태
			if(category != null && kword!=null) {	//검색어가 있다면
				listCount = new SearchService().getListCount(category, kword);
			}else if(category == null && kword!=null) {
				listCount = new SearchService().getListCount(kword);
			}else {					
				listCount = new SearchService().getListCount();
			}
		} else {				//클릭한상태
			listCount = new SearchService().getListCount(categoryNo);
		}
	

		
		 
		
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
		
		if(categoryNo == 0) {
			if(category != null  && kword!=null) {
				bList = new SearchService().selectSearchBookList(pi, category, kword);
			}else {
				bList = new SearchService().selectSearchBookList(pi);	//전체
		}} else {
			bList = new SearchService().selectSearchBookList(pi, categoryNo);	//카테고리 클릭시
			
		}
		

		
		
		
		String page = null;
		if(bList != null) {
			request.setAttribute("bList", bList);
			request.setAttribute("pi", pi);
			request.setAttribute("categoryNo", categoryNo);
			request.setAttribute("category", category);
			request.setAttribute("kword", kword);
			request.setAttribute("listCount", listCount);
			
			page = "WEB-INF/views/search/searchList.jsp";
		} else {
			request.setAttribute("msg", "도서 검색으로 이동 실패");
			page = "WEB_INF/views/common/errorPage.jsp";			
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
