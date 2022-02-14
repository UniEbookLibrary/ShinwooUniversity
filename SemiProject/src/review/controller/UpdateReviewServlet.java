package review.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.vo.Review;
import review.model.vo.ReviewBook;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/updateReview.rv")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		int rId = Integer.parseInt(request.getParameter("rId"));
		String bookImg = request.getParameter("bookImg");
		String bookTitle = request.getParameter("bookTitle");
		String author = request.getParameter("author");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewDate = request.getParameter("reviewDate");
		String reviewContent = request.getParameter("reviewContent");
		String bookId = request.getParameter("bookId");
		int reviewNo =Integer.parseInt(request.getParameter("reviewNo"));
		
		System.out.println(rId);
		System.out.println(bookImg);	//rb
		System.out.println(bookTitle);	//rb
		System.out.println(author);		//rb
		System.out.println(reviewTitle);
		System.out.println(reviewWriter);
		System.out.println(reviewDate);
		System.out.println(reviewContent);
		
		Date sqlDate = null;
		
		if(reviewDate!="") {
	         String[] dateArr = reviewDate.split("-");
	         int year = Integer.parseInt(dateArr[0]);
	         int month = Integer.parseInt(dateArr[1])-1;
	         int day = Integer.parseInt(dateArr[2]);
	         
	         sqlDate = new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
	      }else {
	    	  sqlDate = new Date(new GregorianCalendar().getTimeInMillis());
	      }
		
		ReviewBook rb = new ReviewBook();
		rb.setImageFile(bookImg);
		rb.setBookTitle(bookTitle);
		rb.setAuthor(author);
		rb.setBookNo(bookId);
		
		Review r = new Review();
		r.setReviewTitle(reviewTitle);
		r.setReviewWriter(reviewWriter);
		r.setReviewDate(sqlDate);
		r.setReviewContent(reviewContent);
		r.setReviewNo(reviewNo);
		
		request.setAttribute("rId", rId);
		request.setAttribute("r", r);
		request.setAttribute("rb", rb);
		
		request.getRequestDispatcher("WEB-INF/views/review/reviewUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
