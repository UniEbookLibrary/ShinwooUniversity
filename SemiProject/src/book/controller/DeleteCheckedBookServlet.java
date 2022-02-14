package book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;

/**
 * Servlet implementation class DeleteCheckedBookServlet
 */
@WebServlet("/deleteCheckedBook.bo")
public class DeleteCheckedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCheckedBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] temp  = request.getParameterValues("selectBook");
		String[] bNo = null;
		if(temp.length == 21) {
			bNo = new String[20];
			for(int i = 1; i < temp.length; i++) {
				bNo[i - 1] = temp[i];
			}
		} else {
			bNo = temp;
		}
		
		int result = new BookService().deleteBook(bNo);
		
		if(result >= bNo.length) {
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
