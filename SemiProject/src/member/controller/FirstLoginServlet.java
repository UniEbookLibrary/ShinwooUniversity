package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class FirstLoginServlet
 */
@WebServlet(name="FirstLoginServlet", urlPatterns="/firstLogin.me")
public class FirstLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String address1 = request.getParameter("addr1");
		String address2 = request.getParameter("addr2");
		String phone = null;
		String address = null;
		
		if(!number2.equals("")) {
			phone = number1 + number2;
		}
		
		if(!address2.equals("")) {
			address = address1 + "&&" + address2;
		}
		
		String email = email1.concat(email2);
		
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPwd(password);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		
		int result = new MemberService().firstUpdate(m);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "에러");
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
