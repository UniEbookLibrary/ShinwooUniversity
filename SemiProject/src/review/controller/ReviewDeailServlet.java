package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewBookService;
import review.model.service.ReviewService;
import review.model.vo.Review;
import review.model.vo.ReviewBook;

/**
 * Servlet implementation class ReviewDeailServlet
 */
@WebServlet("/detail.rv")
public class ReviewDeailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rId = Integer.parseInt(request.getParameter("rId"));
		String upd = request.getParameter("upd");
		
		Review r = new ReviewService().selectReview(rId, upd);
		ReviewBook rb = new ReviewBookService().selectReviewBook(rId);
		
		String page = null;
		if(r != null) {
			page = "WEB-INF/views/review/writedetail.jsp";
			request.setAttribute("r", r);
			request.setAttribute("rb", rb);
			//request.setAttribute("list", list);
		}else {
			request.setAttribute("msg", "오류");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
