package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.Member;
import question.model.service.QuestionService;
import question.model.vo.Question;
import review.model.vo.PageInfo;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet("/questionList.li")
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
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
		
		QuestionService qService = new QuestionService(); 
		boolean isAdmin = ((Member)request.getSession().getAttribute("loginUser")).getMemberType().toUpperCase().equals("MASTER") ? true : false;
		String memberId = ((Member)request.getSession().getAttribute("loginUser")).getMemberId();
		
		if(isAdmin) {
			listCount = qService.getAdminListCount();
		} else {
			listCount = qService.getUserListCount(memberId);
		}
		
		currentPage = 1; 
		if(request.getParameter("currentPage") != null) { 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit); 
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		ArrayList<Question> list = null;
		
		if(isAdmin) {
			list = qService.selectAdminList(pi);
		} else {
			list = qService.selectUserList(pi, memberId);
		}
		
		String page = null;
		if(list != null) {
			request.setAttribute("qList", list);
			request.setAttribute("pi", pi);
			request.setAttribute("isAdmin", isAdmin);
			page = "WEB-INF/views/question/questionList.jsp";
		} else {
			request.setAttribute("msg", "문의 목록 조회 실패");
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
