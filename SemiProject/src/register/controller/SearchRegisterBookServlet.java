package register.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.Member;

/**
 * Servlet implementation class RegisterBookFormServlet
 */
@WebServlet("/searchregbook.bo")
public class SearchRegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRegisterBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginUser = (Member)(request.getSession().getAttribute("loginUser"));
		
		String page = null;
		if(loginUser != null && loginUser.getMemberType().equals("MASTER")) {
			page = "WEB-INF/views/register/searchRegisterBook.jsp";
		} else {
			request.setAttribute("msg", "관리자만 볼 수 있는 메뉴입니다.");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
