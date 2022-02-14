package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.Member;
import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/insertReview.rv")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 리뷰이름, 리뷰내용, 작성자 id, 책id
		String reviewTitle = request.getParameter("title");
		String reviewContent = request.getParameter("content");
		String reviewWriter = ((Member)request.getSession().getAttribute("loginUser")).getMemberId();
		String bookName = request.getParameter("uploadName3");
		
		Review r = new Review();
		
		r.setReviewTitle(reviewTitle);
		r.setReviewContent(reviewContent);
		r.setReviewWriter(reviewWriter);
		r.setBookName(bookName);
		
		int result = new ReviewService().insertReview(r);
		
		if(result > 0) {
			response.sendRedirect("reviewList.rv");
		}else {
	         request.setAttribute("msg", "공지사항 등록에 실패하였습니다.");
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
