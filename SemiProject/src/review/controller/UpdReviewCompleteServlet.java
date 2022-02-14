package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class UpdReviewCompleteServlet
 */
@WebServlet("/updateReviewComplete.rv")
public class UpdReviewCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdReviewCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String uploadName3 = request.getParameter("uploadName3");
		String reviewWriterId = request.getParameter("reviewWriterId");
		int rId = Integer.parseInt(request.getParameter("rId"));
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(uploadName3);
		System.out.println(reviewWriterId);
		System.out.println(reviewNo);
		System.out.println(rId);
		
		Review r = new Review();
		r.setReviewTitle(title);
		r.setReviewContent(content);
		r.setBookName(uploadName3);
		r.setMemberId(reviewWriterId);
		r.setReviewNo(reviewNo);
		
		int result = new ReviewService().updateReview(r);
		
		String page = null;
		if(result > 0) {
			response.sendRedirect("detail.rv?rId=" + rId + "&upd=Y");
		}else {
			request.setAttribute("msg", "게시글 수정 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
