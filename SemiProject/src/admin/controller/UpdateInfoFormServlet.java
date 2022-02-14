package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.UserList;

/**
 * Servlet implementation class ChangeInfoFormServlet
 */
@WebServlet("/updateInfoForm.ui")
public class UpdateInfoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mi = request.getParameter("mi");
		System.out.println(mi);
		UserList ul = new AdminService().selectUserInfo(mi);
		
		String page = null;
		if(ul != null) {
			System.out.println(ul);
			request.setAttribute("ul", ul);
			page = "WEB-INF/views/admin/updateInfoForm.jsp";
		} else {
			request.setAttribute("msg", "게시글 조회에 실패");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
//		String userName = request.getParameter("name");
//		String userdp = request.getParameter("department");
//		String userPhone = request.getParameter("phone");
//		String userAddress = request.getParameter("address");
//		String userEmail = request.getParameter("email");
		
		//UserList userList = new AdminService().selectAdmin(ul);
		
//		request.setAttribute("id", userId);
//		request.setAttribute("name", userName);
//		request.setAttribute("department", userdp);
//		request.setAttribute("phone", userPhone);
//		request.setAttribute("address", userAddress);
//		request.setAttribute("email", userEmail);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
