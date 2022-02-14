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
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/userInfoUpdate.ui")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uLId = request.getParameter("id");
		String uLName = request.getParameter("name");
		String uLDepartment = request.getParameter("department");
		String uLEmail = request.getParameter("email");
		
		UserList ul = new UserList(uLId, uLName, uLDepartment, null, null, uLEmail, null);
		
		int result = new AdminService().updateUserInfo(ul);
		System.out.println(uLId);
		if(result > 0) {
			response.sendRedirect("userList.ul?mi=" + uLId);
		} else {
			request.setAttribute("msg", "회원 정보 수정 실패");
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
