package reqBook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.vo.Book;
import reqBook.model.service.ReqBookService;

/**
 * Servlet implementation class CheckBookExist
 */
@WebServlet("/checkExistBook.bo")
public class CheckBookExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBookExist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title").trim();
		String author = request.getParameter("author").trim();
		String publisher = request.getParameter("publisher").trim();
		
		Book b = new Book();
		b.setBookTitle(title);
		b.setAuthor(author);
		b.setPublisher(publisher);
		
		int result = new ReqBookService().checkBookExist(b); 
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("have");
		} else{
			out.println("nothave");
		}
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
