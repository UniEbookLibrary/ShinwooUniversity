package book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookDetailService;
import member.vo.Member;

/**
 * Servlet implementation class RentalBookServlet
 */
@WebServlet("/rentalBook.bo")
public class RentalBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bNo = request.getParameter("bNo");
		System.out.println(bNo);
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		String rId = null;
		if(loginUser != null) {
			rId = loginUser.getMemberId();
		}
		System.out.println(rId);
		int result = new BookDetailService().RentalBook(rId, bNo);
		System.out.println(result);
		
		if(result > 0) {
			response.sendRedirect("bookDetail.bo?bNo=" + bNo);
		} else {
			request.setAttribute("msg", "도서 대출 실패");
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
