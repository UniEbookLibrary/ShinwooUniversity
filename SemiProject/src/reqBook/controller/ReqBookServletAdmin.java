package reqBook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reqBook.model.service.ReqBookService;
import reqBook.model.vo.ReqBook;

/**
 * Servlet implementation class ReqBookServlet
 */
@WebServlet("/reqBook.con")
public class ReqBookServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqBookServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reqNo = Integer.parseInt(request.getParameter("reqNo")); 
		String writer = request.getParameter("writer");
		
		ReqBook r = new ReqBookService().sendReqinfo(reqNo);
		
		String page = null;
		if(r != null) {
			page = "WEB-INF/views/reqBook/ReqBookFormAdmin.jsp";
			request.setAttribute("r", r);
			request.setAttribute("writer", writer);
			
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", " 실행 실패");
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
