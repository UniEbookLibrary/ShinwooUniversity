package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewBookService;
import review.model.vo.ReviewBook;

/**
 * Servlet implementation class FindBookFormServlet
 */
@WebServlet("/findBook.rv")
public class FindBookFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ReviewBook> list = new ReviewBookService().selectBookList();
		
		String page = null;
		
		if(list != null) {	//noticeList.jsp
			request.setAttribute("list", list);
			page = "WEB-INF/views/review/findBook.jsp";
		} else {			//errorPage.jsp
			request.setAttribute("msg", "오류");
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
