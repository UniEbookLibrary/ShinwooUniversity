package book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;

/**
 * Servlet implementation class DeleteOneBookServlet
 */
@WebServlet("/deleteOneBook.bo")
public class DeleteOneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOneBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookNo = request.getParameter("bNo");
		String[] bNo = {bookNo};
		
		
		int result = new BookService().deleteBook(bNo);
		
		if(result > 0) {
			response.sendRedirect("ownBookList.li");
		} else {
			request.setAttribute("msg", "도서 목록 조회 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
