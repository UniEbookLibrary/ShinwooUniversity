package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("userNo");
		String memberPwd = request.getParameter("userPwd");
//		System.out.println(memberPwd);
		Member loginUser = new MemberService().loginMember(memberId, memberPwd);
		
		if(loginUser != null) {
			HttpSession session = request.getSession();

			session.setMaxInactiveInterval(6000); 	
			session.setAttribute("loginUser", loginUser);
			String status = new MemberService().isFirstLogin(memberId);
			if(status.equals("N")) {
				request.setAttribute("loginUser", loginUser);
				session.setAttribute("loginUser", loginUser);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/firstLogin.jsp");
				view.forward(request, response);
			}else {
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath());
			}
		}else {
			request.setAttribute("msg", "로그인 실패");
			System.out.println(memberPwd);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
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
