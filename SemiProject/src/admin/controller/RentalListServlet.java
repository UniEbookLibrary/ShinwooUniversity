package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.RentalBook;

/**
 * Servlet implementation class RentalList
 */
@WebServlet("/rentalList.rt")
public class RentalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<RentalBook> rList = new AdminService().selectRentalBookList();
		
		String page = null;
		if(rList != null) { 
			request.setAttribute("rList", rList);
			page = "WEB-INF/views/admin/rentalList.jsp";
		} else { 
 			request.setAttribute("msg", "회원 조회 실패");
 			page = "WEB_INF/views/common/errorPage.jsp";
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
